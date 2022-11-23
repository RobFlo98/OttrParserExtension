import defusedxml.ElementTree as ET
import re


def get_namespace(tag):
    m = re.match(r'\{.*\}', tag)
    return m.group(0) if m else ''

def find_ottr(text):
    if not ('<ottr>' in text and '</ottr>' in text):
        return None
    else:

        start = re.search(r'<ottr>',text).span()[1]
        end = re.search(r'</ottr>',text).span()[0]

        return text[start:end].strip()

TAG_SITEINFO = 'siteinfo'
TAG_PAGE = 'page'
TAG_REVISION = 'revision'
TAG_TEXT = 'text'

def xml_to_stotter(xml_filename,stotter_filename):


    tree = ET.parse(xml_filename)
    root = tree.getroot()


    tags = {elem.tag for elem in tree.iter()}

    namespaces = list({get_namespace(tag) for tag in tags})

    pages = []
    for namespace in namespaces:
        pages.extend(tree.findall(f"{namespace}{TAG_PAGE}"))

    file = open(stotter_filename,'w')

    for page in pages:
        revisions = page.findall(f"{namespaces[0]}revision")
        text = revisions[0].find(f"{namespaces[0]}text")
        ottr_text = find_ottr(text.text)
        if ottr_text:
            file.write(ottr_text)
            file.write('\n')

    file.close()

xml_to_stotter('DiProMag_Wikidatabase.xml','DiProMag_Wikidatabase.stOtter')



