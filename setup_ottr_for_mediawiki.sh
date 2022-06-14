#!/bin/bash -
#===============================================================================
#
#          FILE: setup_ottr_for_mediawiki.sh
#
#         USAGE: ./setup_ottr_for_mediawiki.sh
#
#   DESCRIPTION: Setup OttrParserExtension for semantic media wiki. 
#
#       OPTIONS: ---
#  REQUIREMENTS: ---
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: Oliver Tautz
#  ORGANIZATION: University of bielefeld
#       CREATED: 06/14/2022 04:05:33 PM
#      REVISION: 0.1
#===============================================================================

set -o nounset                                  # Treat unset variables as an error

Help()
{
   # Display Help
   echo "Install OttrParserExtension for semantic media wiki."
   echo "More help here: https://github.com/Oliver-Tautz/OttrParserExtension."
   echo
   echo "Syntax: setup_ottr_for_mediawiki.sh [-hc] [-p path] [-e path]"
   echo "options:"
   echo "h     Print this Help."
   echo "p     use explicit python/conda binary instead of the one on PATH"
   echo "c     use conda instead of pip. Not implemented ..."
}


pythonpath="python"
envpath="ottr_env"
setuppath="."

#Help
while getopts ":hcp:e:" option; do
   case $option in
      h) # display Help
          Help
          exit;;
      p)
          pythonpath=$OPTARG;;
      i)
          setuppath=$OPTARG;;
      c)
          echo "Conda Setup not implemented :("
          exit;;
      \?)
        echo "Error: Invalid option"
        Help
        exit;;
   esac
done

while true; do
   read -p  "Setup and install ottrparser into new environment at $envpath ? [Y/N]" yn
   case $yn in
   [Yy]* ) $pythonpath -m venv $envpath
           $envpath/bin/python -m pip install $setuppath; 
           break;; 
   [Nn]* ) exit;;
   * ) echo "Please anser yes or no";;
   esac
done

