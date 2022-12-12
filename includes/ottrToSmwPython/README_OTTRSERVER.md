# OTTR-Server

Import and export .stottr files to and from OttrWiki.

## Installation

1. Install OttrWiki (Mediawiki+SemanticMediaWiki+OttrParserExtension)
2. set `$wgEnableBotPasswords=True;` in your LocalSettings.php
3. create a bot on the page Special:BotPasswords and write down username and password
4. change the variables in ottrServerExampleConfig.cfg accordingly
5. start the server with `python ottrServer.py` 

Thats it! You can now test your setup with e.g. this python script:

```
        import requests
        file = open('stottr_file.stotter')
        data = file.read()
        file.close()

        body = {"data": data,
                "template_namespace": "Template",
                "instance_namespace": "",
                "overwrite":"True"
        }

        r = requests.post("http://127.0.0.1:5000/ottr_post/api/stottr_file",json=body)

        print(r.text)
```