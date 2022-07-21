
Default_Namespaces = ['Main','Template','Dpm']

# acceptable namespaces for ottr_templates
# add yours to surpress warning
ottr_template_namespaces = ('dpm','template')

# typehint for ottr types ... will be printed next to the type in forms
form_typehint_mapping = {'xsd:date': "--date =(YYYY-MM-DD)",
                         'dpm:User': "a user",
                         'xsd:float': "--date =(YYYY-MM-DD)" }

# typehint for lists. printed in forms
form_listhint = "--elements in ( .. ) separated by ','"