# Switch to something from wiki doc!
# or even simpler ....
import hashlib
import base64
import requests
import urllib
OTTR_EXAMPLE = """@prefix owl: <http://www.w3.org/2002/07/owl#> .
@prefix ax: <http://tpl.ottr.xyz/owl/axiom/0.1/> .
@prefix ex: <http:example.com/ns#>

ex:NamedPizzaTemplate[owl:Class ?pizza, ? owl:NamedIndividual ?country, NEList<ottr:IRI> ?toppings, ?test] :: {
  ax:SubClassOf(?pizza, ex:NamedPizza),
  ax:SubObjectHasValue(?pizza, ex:hasCountryOfOrigin, ?country),
  ax:SubObjectAllValuesFrom(?pizza, ex:hasTopping, _:toppingsUnion),
  rstr:ObjectUnionOf(_:toppingsUnion, ?toppings),
  ottr:Triple(?pizza,ex:test,"Hallo Welt!"^^xsd:string),
  cross | ax:SubObjectSomeValuesFrom(?pizza, ex:hasTopping, ++?toppings)
} .

ex:NamedPizzaTemplate(ex:Margherita, ex:Italy, (ex:Mozzarella, ex:Tomato)) .
"""

OTTR_EXAMPLE_TEMPLATE = """@prefix owl: <http://www.w3.org/2002/07/owl#> .
@prefix ax: <http://tpl.ottr.xyz/owl/axiom/0.1/> .
@prefix ex: <http:example.com/ns#>

ex:NamedPizzaTemplate[owl:Class ?pizza, ? owl:NamedIndividual ?country, NEList<ottr:IRI> ?toppings, ?test] :: {
  ax:SubClassOf(?pizza, ex:NamedPizza),
  ax:SubObjectHasValue(?pizza, ex:hasCountryOfOrigin, ?country),
  ax:SubObjectAllValuesFrom(?pizza, ex:hasTopping, _:toppingsUnion),
  rstr:ObjectUnionOf(_:toppingsUnion, ?toppings),
  ottr:Triple(?pizza,ex:test,"Hallo Welt!"^^xsd:string),
  cross | ax:SubObjectSomeValuesFrom(?pizza, ex:hasTopping, ++?toppings)
} .

ex:NamedPizzaTemplate(ex:Margherita, ex:Italy, (ex:Mozzarella, ex:Tomato)) .
"""


def _clean_comments(ottr_thing):
    lines = ottr_thing.split('\n')
    # remove comments before deciding
    for i in range(len(lines)):
        if lines[i] != '' and lines[i][0] == '#':
            lines.pop[i]
        elif '#' in lines[i]:
            lines[i] = lines[i].split('#')[0]

    # rejoin

    text = '\n'.join(lines)
    return text


def is_template(ottr_thing):
    text = _clean_comments(ottr_thing)
    # template if contains {}
    if '{' in text and '}' in text:
        return True
    else:
        return False


def get_template_name_from_template_string(template_string):
    template_string = _clean_comments(template_string)
    return template_string.split('[')[0]


def get_template_name_from_instance_string(instance_string):
    instance_string = _clean_comments(instance_string)
    return instance_string.split('(')[0]


def hash_instance(string, length=10):
    byt = bytes(string, 'utf-8')
    hash = hashlib.md5(byt)
    hash = base64.urlsafe_b64encode(hash.digest())

    # truncate hash ... this is safe as far as I know
    hash = hash[:length]
    return hash.decode('utf8')





def edit_or_create_page(title, text,mediawiki_url,bot_user_name,bot_user_password):


    S = requests.Session()

    # use urlparse or similar here!
    urllib.parse.urljoin(mediawiki_url,'api.php')
    URL = f"{mediawiki_url}/api.php"

    # Step 1: GET request to fetch login token
    PARAMS_0 = {
        "action": "query",
        "meta": "tokens",
        "type": "login",
        "format": "json"
    }

    R = S.get(url=URL, params=PARAMS_0)
    DATA = R.json()

    LOGIN_TOKEN = DATA['query']['tokens']['logintoken']

    # Step 2: POST request to log in. Use of main account for login is not
    # supported. Obtain credentials via Special:BotPasswords
    # (https://www.mediawiki.org/wiki/Special:BotPasswords) for lgname & lgpassword
    PARAMS_1 = {
        "action": "login",
        "lgname": bot_user_name,
        "lgpassword": bot_user_password,
        "lgtoken": LOGIN_TOKEN,
        "format": "json"
    }

    R = S.post(URL, data=PARAMS_1)
    print(R.json())

    # Step 3: GET request to fetch CSRF token
    PARAMS_2 = {
        "action": "query",
        "meta": "tokens",
        "format": "json"
    }

    R = S.get(url=URL, params=PARAMS_2)
    DATA = R.json()
    print(DATA)
    CSRF_TOKEN = DATA['query']['tokens']['csrftoken']


    # Step 4: POST request to edit a page
    PARAMS_3 = {
        "action": "edit",
        "title": title,
        "token": CSRF_TOKEN,
        "format": "json",
        "text": text
    }

    R = S.post(URL, data=PARAMS_3)
    DATA = R.json()
    print(DATA)


