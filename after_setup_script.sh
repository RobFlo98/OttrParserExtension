#!/bin/bash -
#===============================================================================
#
#          FILE: setup.sh
#
#         USAGE: ./setup.sh
#
#   DESCRIPTION: A simple script calling some docker and mediawiki funtions to 
#                finisch up after manual setup. 
#
#       OPTIONS: --localsettings-path --mediawiki-container --mediawiki-volume
#  REQUIREMENTS: getopt
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: Oliver Tautz, 
#  ORGANIZATION: Bielefeld University
#       CREATED: 10/19/2022 03:41:31 PM
#      REVISION: 0.1
#===============================================================================


set -o nounset                                  # Treat unset variables as an error



#### PARSE ARGS ####


MEDIAWIKI_CONTAINER_NAME='OTTRWIKI'
LOCALSETTINGS_PATH='LocalSettings.php'
MEDIAWIKI_VOLUME_NAME='WIKIVOLUME'
 
 usage()
{
  echo  "Usage setup [--localsettings-path LOCALSETTINGS_PATH] [--mediawiki-container MEDIAWIKI_CONTAINER_NAME] [--mediawiki-volume MEDIAWIKI_VOLUME_NAME]"
  exit 2
}

PARSED_ARGUMENTS=$(getopt -a setup -o '' --long localsettings-path:,mediawiki-container:,mediawiki-volume: -- "$@")
VALID_ARGUMENTS=$?
if [ "$VALID_ARGUMENTS" != "0" ]; then
  usage
fi

eval set -- "$PARSED_ARGUMENTS"
while :
do
  case "$1" in
    --localsettings-path)  LOCALSETTINGS_PATH="$2" ; shift 2 ;;
    --mediawiki-container) MEDIAWIKI_CONTAINER_NAME="$2"   ; shift 2 ;;
    --mediawiki-volume)    MEDIAWIKI_VOLUME_NAME="$2"   ; shift 2 ;;
    # -- means the end of the arguments; drop this, and break out of the while loop
    --) shift; break ;;
    # If invalid options were passed, then getopt should have reported an error,
    # which we checked as VALID_ARGUMENTS when getopt was called...
    *) echo "Unexpected option: $1 - this should not happen."
       usage ;;
  esac
done

### Check Input ####

## Check if Volume exists


# get path of volume mount
volume_path=$(docker inspect $MEDIAWIKI_VOLUME_NAME 2>&1 | jq '.[0].Mountpoint')


if [ "$volume_path" = "null" ]; then
    echo "The docker volume does not exist! Use the --mediawiki-volume option. You can find your volume with 'docker volume ls'."
    exit
fi


## Check if Container exists

check_container=$(docker container inspect $MEDIAWIKI_CONTAINER_NAME | jq '.')


if [ "$check_container" = "[]" ]; then
    echo "The docker container does not exist! Use the --mediawiki-container option. You can find your volume with 'docker container ls'."
    exit
fi




## Check if LocalSettings path exists


if [[ ! -f "LocalSettings.php" ]] ; then
    read -p "$LOCALSETTINGS_PATH not found! Do you want to search for it in your home folder?[y/n]" yn
    case $yn in
        [Yy]* ) found=$(find /home -name LocalSettings.php -print -quit 2>/dev/null);
                if [ -z "$found" ]; then
                    echo "No LocalSettings.php found in your home! Please restart this script with the --localsettings-path option pointing to your file."
                    exit
                else
                    echo "Found $found"
                    LOCALSETTINGS_PATH=$found
                    echo "Continuing."
                fi
                ;;
        *)  echo "$LOCALSETTINGS_PATH not found. Abort."
            exit;;
    esac
fi


####Do things :)####

# remove quotes
volume_path=${volume_path:1:-1}

# copy LocalSettings.php to volume
cp $LOCALSETTINGS_PATH "$volume_path/LocalSettings.php"

# add some lines to Localsettings (activate extensions)
cat add_to_localsettings.php >> "$volume_path/LocalSettings.php"

# update database for smw to function ...
docker exec -t $MEDIAWIKI_CONTAINER_NAME php maintenance/update.php


