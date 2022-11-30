import defusedxml.ElementTree as ET
import re
from pathlib import Path

import argparse


#### Helper Functions

def _get_namespace(tag):
    m = re.match(r'\{.*\}', tag)
    return m.group(0) if m else ''


def _find_ottr_tag(text):
    if not ('<ottr>' in text and '</ottr>' in text):
        return None
    else:

        start = re.search(r'<ottr>', text).span()[1]
        end = re.search(r'</ottr>', text).span()[0]

        text = text[start:end].strip()

        return text


def _find_ottr_instance(text):
    def get_stottr_string(template_name, args):
        return f"{template_name}({', '.join(args)})."

    if not "ottr:SingleInstanceForMultiCreation1" in text:
        return None
    else:
        start = re.search(r'ottr:SingleInstanceForMultiCreation1', text).span()[1]
        end = re.search(r'}}', text).span()[0]

        args = []
        for line in text[start:end].split('\n'):
            split = line.split('=')
            if len(split) > 1:

                if split[0] == '|template_name':
                    template_name = split[1]
                if 'arg_' in split[0]:
                    arg_number = re.search(r'\d+', split[0])
                    if arg_number:
                        args.append(split[1])
    return get_stottr_string(template_name, args)


def _apply(function, filenames):

    return_list = []

    for filename in filenames:

        filename = Path(filename)

        try:
            ret = function(filename)
        except:
            print(f" file {filename.absolute()} not found or cant be accessed!")
            exit(-1)
        return_list.append(ret)
    return return_list


def _get_xml_page(title, text):
    # make this xml compatible ...
    text = text.replace('<', '&lt;')
    text = text.replace('>', '&gt;')

    return ET.fromstring(f'''<page> 
    <title>{title}</title>
    <revision>
        <contributor>
        <username>OttrParserImportScript</username>
      </contributor>
      <model>wikitext</model>
      <format>text/x-wiki</format>
      <text xml:space=\"preserve" bytes=\"4553\">{text}</text>
    </revision>
  </page>''')




def _prompt_user(filename):
    filename=Path(filename)
    if filename.is_file():
        inp = input(f"{filename.absolute()} already exists. Do you want to overwrite it? [y/n]:")
        if inp.lower()[0] != 'y':
            print('abort ...')
            exit(-1)
    else:
        return True

### Constants

TAG_SITEINFO = 'siteinfo'
TAG_PAGE = 'page'
TAG_REVISION = 'revision'
TAG_TEXT = 'text'

OPTION_XML_TO_STOTTR_ARGPARSE_NAME = '--xml-to-stottr'
OPTION_STOTTR_TO_XML_ARGPARSE_NAME = '--stottr-to-xml'
OPTION_OUTFILE_NAME='--out'
OPTION_FORCE_NAME='--f'

OPTION_XML_TO_STOTTR='xml_to_stottr'
OPTION_STOTTR_TO_XML = 'stottr_to_xml'
OPTION_OUTFILE='out'
OPTION_FORCE = 'f'

CONST_FILENAME_EMPTY_WIKIXML = 'empty_wikimedia_tree.xml'

# importable functions

def xml_to_stotter(xml_filename):
    tree = ET.parse(xml_filename)


    tags = {elem.tag for elem in tree.iter()}

    namespaces = list({_get_namespace(tag) for tag in tags})

    pages = []
    for namespace in namespaces:
        pages.extend(tree.findall(f"{namespace}{TAG_PAGE}"))



    templates = []
    instances = []
    for page in pages:
        revisions = page.findall(f"{namespaces[0]}revision")
        text = revisions[0].find(f"{namespaces[0]}text")
        ottr_tag_text = _find_ottr_tag(text.text)
        ottr_instance_text = _find_ottr_instance(text.text)
        if ottr_tag_text:
            templates.append(ottr_tag_text)
        if ottr_instance_text:
            instances.append(ottr_instance_text)

    return templates,instances


def write_stottr_to_mediawiki_xml(titles, prefixes, texts, out_filename):
    texts = [f"<ottr>\n{text}\n</ottr>" for text in texts]
    tree = ET.parse(CONST_FILENAME_EMPTY_WIKIXML)
    root = tree.getroot()
    for title, text in zip(titles, texts):
        root.append(_get_xml_page(title, text))

    tree.write(out_filename)


def parse_stottr_string(stottr_string):
    lines = [l + '\n' for l in stottr_string.split('\n')]


    # init return lists
    prefixes = []
    ottr_things = []

    # only used in loop
    current_thing = []

    # template_name_line

    for line in lines:

        # prefix line
        if line.strip() and line.strip()[0:7] == '@prefix':
            prefixes.append(line)

        # comment line
        elif line.strip() and line.strip()[0] == '#':
            current_thing.append(line)

        # comment in line after content
        elif "#" in line.strip():
            # closing line with comment after
            if line.split('#')[0].strip()[-1] == '.':
                current_thing.append(line)
                ottr_things.append(''.join(current_thing))
                current_thing = []
            # non-closing line with comment after.
            else:
                current_thing.append(line)
        # closing line without comment afet
        elif line.strip() and line.strip()[-1] == '.':
            current_thing.append(line)
            ottr_things.append(''.join(current_thing))
            current_thing = []
        else:
            # non-closing line without comment
            current_thing.append(line)

    return prefixes, ottr_things

def parse_stottr_file(filename):
    """
    Takes filepath to .stottr file and returns prefixes, and things as a list.
    """

    # read file
    stottrfile = open(filename, 'r')
    stottr_string = stottrfile.read()
    stottrfile.close()
    prefixes, ottr_things = parse_stottr_string(stottr_string)
    return prefixes, ottr_things






if __name__ == "__main__":

    # argparse setup
    parser = argparse.ArgumentParser(description='Convert mediawiki .xml dump to stOttr and vice-versa.')
    parser.add_argument(OPTION_XML_TO_STOTTR_ARGPARSE_NAME, nargs='+', action='append', required=False,help="Parse list of mediawiki xml files to stottr.")
    parser.add_argument(OPTION_STOTTR_TO_XML_ARGPARSE_NAME, nargs='+', action='append', required=False,help="Parse list of stottr files to mediawiki compatible xml.")
    parser.add_argument(OPTION_OUTFILE_NAME, type=str, default='parsed',help="Outfile basename. The suffix will be set accordingly (.xml/.strottr)")
    parser.add_argument(OPTION_FORCE_NAME, action='store_true',default=False,help="Overwrite existing files without prompt.")

    # xml_to_stotter('DiProMag_Wikidatabase.xml','DiProMag_Wikidatabase_templates.stOtter','DiProMag_Wikidatabase_instances.stOtter')

    args = parser.parse_args()
    args = (vars(args))


    # catch wrong user input
    if not (args[OPTION_XML_TO_STOTTR] or args[OPTION_STOTTR_TO_XML]):
        print(f"You need to use either {OPTION_STOTTR_TO_XML_ARGPARSE_NAME} or {OPTION_XML_TO_STOTTR_ARGPARSE_NAME} with at least one filename.")
        exit(-1)
    if args[OPTION_XML_TO_STOTTR] and args[OPTION_STOTTR_TO_XML]:
        print(f"You cant use both {OPTION_STOTTR_TO_XML_ARGPARSE_NAME} and {OPTION_XML_TO_STOTTR_ARGPARSE_NAME} at the same time! What do you want to do?")
        exit(-1)

    if args[OPTION_XML_TO_STOTTR]:
        template_strings = []
        instance_strings=[]

        out_list = _apply(xml_to_stotter, args[OPTION_XML_TO_STOTTR][0])


        for templates,instances in out_list:
            template_strings.extend(templates)
            instance_strings.extend(instances)




        basename = Path(args[OPTION_OUTFILE]).parent / Path(args[OPTION_OUTFILE]).stem

        template_filename = Path(f"{basename}_templates.stottr")
        instance_filename = Path(f"{basename}_instances.stottr")


        # Check if files already exist and prompt user.
        if not args[OPTION_FORCE]:

            _prompt_user(template_filename)
            _prompt_user(instance_filename)


        # write to file.
        template_file = open(template_filename,'w')
        instance_file = open(instance_filename,'w')

        template_file.write('\n'.join(template_strings))
        instance_file.write('\n'.join(instance_strings))

        template_file.close()
        instance_file.close()

    if args[OPTION_STOTTR_TO_XML]:


        prefixes = []
        things = []
        out_list = _apply(parse_stottr_file, args[OPTION_STOTTR_TO_XML][0])


        for prefs, thingies in out_list:
            prefixes.extend(prefs)
            things.extend(thingies)

        ##TODO Handle prefixes somehow!


        ## TODO how/ where to get titles?!

        titles = [f"testimport_{x}" for x in range(len(things))]


        basename = Path(args[OPTION_OUTFILE]).parent / Path(args[OPTION_OUTFILE]).stem
        xml_name = f"{basename}.xml"

        if not args[OPTION_FORCE]:

            _prompt_user(xml_name)


        write_stottr_to_mediawiki_xml(titles, None, things, xml_name)




