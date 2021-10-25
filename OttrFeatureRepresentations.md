# OTTR Feature Representations

## Prefix

Only writes subobject on a prefix page, not on usual pages.
In Template:ottr:Prefix:
``` 
{{#subobject: |iri={{#replace:{{#replace:'<iri>'|<|}}|>|}} |namespace=<namespace>|subobject-category=OTTR-Prefix}}
```
The namespace is the short version.

Displays on the special page:
> 1. Prefix: **prefix** : '<'iri'>'

On other pages (if the prefix is not on the special page):

> Prefix **prefix** is not defined on page [Ottr:OttrPrefixes]()!

With the check query:
```
{{#if:
  {{#ask:
   [[-Has subobject::Ottr:OttrPrefixes]][[namespace::{{{2}}}]] 
   |?namespace
   |format=list
   |link=none
  }}
  |
  |<above_warning_msg>
}}
```

## Template Call

```
{{<template_name>
  |<arg_1_representation>
  |...
  |<arg_N_representation>
  |ottr_arg_type_1=<type_representation_arg_1>
  |...
  |ottr_arg_type_N=<type_representation_arg_N>
  |call_occurence=<call_occurence>
  |call_depth={{#expr: {{{call_depth}}} + 1}}
}}
```
`call_occurence` is first initialised with `{{FULLPAGENAME}}_<additional_pos_info>` and call depth with 1.

The `ottr_arg_type_X` arguments contain a type string with string elements (separated by ***§***) that represent a known type the argument.


### None Arguments
Input arguments `none` and `ottr:none` are replaced by the empty string and have the type `ottr:none`.

## Optional Argument Check
If a parameter has the option **?**, it can be none. All other arguments are checked for not `none` with this expression:
```
{{#iferror: <inner_optional_check>||<the inner template>}}
```
The inner optional check checks for every not optional argument:
```
{{#if: {{{<parameter_position>}}}||<strong class="error">b</strong>}}<inner_optional_check>
```
It does not throw an error or warning, because it is a feature of the ottr language to be a silent template instance if an argument is None, but the template is not allowed to generate its own instances under these conditions.

## Default Value
All usages of an argument with a default value in a template have the following format (normally `{{{%s|}}}`)
```
{{#if: {{{<parameter_position>|}}}|{{{<parameter_position>}}}|<default_represenation>}}
```

## Blank Node Representation
```
ottr:blank:{{{call_occurrence}}}_BN-<blank_node_name>
```
The blank node name for an anonymous blank node is a number, that increases for every anonymous blank node in a call.
The type representation of a blank_node is `ottr:blank`

## Non Blank Argument Check
Check with iferror for error in non blank check and use variable for error msg string:
```
{{#iferror: <inner non blank check>|{{ottr:ErrorMsg|{{#var:ottr_arg_non_blankerror_msg}}|code=3}}|<the inner template>}}
```
Find ottr:blank§ in the type representation of the argument, if so then write variable with error msg, else check other arguments.
```
{{#if: {{#pos:{{{ottr_arg_type_<parameter_position>|}}}|ottr:blank§}}
  |{{#vardefine:ottr_arg_non_blankerror_msg|{{#var:ottr_arg_non_blankerror_msg}}Argument %i (%s) is a blank node, but declared as non blank<br/>}}<strong class="error">b</strong>
  |
}}<inner non blank check>
```

## Type Restriction Check
There is a difference between a hard check of different ottr (literal and iri) types. If they fail they produce an error, but no triples and other template calls. 
Inferenced types (by category relations) produce only warnings and do not stop the evaluating of the template.

An ottr:none argument is every type.

### Simple Type Check
```
{{#iferror:
  {{#if: {{{<parameter_position>|}}}
    |{{#if: {{#pos:{{{ottr_arg_type_<parameter_position>|}}}|<restricted_type_represenation>§}}
      |
      |{{#if: {{#pos:{{{ottr_arg_type_%i}}}|xsd:string}}
        |{{#if: {{#pos:{{{ottr_arg_type_%i|}}}|%s§}}
          |
          |<strong class="error">b</strong>
         }}
        |<strong class="error">b</strong>
      }}
    }}
  |{{ottr:ErrorMsg|Have not found a (simple) type match of the input '{{{<parameter_position>|}}}' for argument <parameter_position> in template '<template_name>' (<restricted_type_represenation>§ in '{{{ottr_arg_type_<parameter_position>|}}}')|code=4}}
  |<complex_type_check>
  }}
}}
```
`<restricted_type_represenation>` is the reduced type without LUB, NEList is also List and a requested type different to "rdfs:resource", "xsd:boolean", "xsd:float", "xsd:integer" and "xsd:string" is only represented as "ottr:IRI"


### Complex Type Check


Class inheritance in SMW with Categories.
For `rdfs:type`: On Instance page: `[[Category:<class_page>]]`.
For `rdf:SubClassOf`: On Page `Category:<sub_class>`: `[[Category:<class>]]`.

If the requested type is not a simple type, a nested (a more complex) type check is added to the simple type check.

The complex check starts with:
```
{{#if:{{#pos:{{{ottr_arg_type_<parameter_position>}}}|ottr:IRI}}|<inner_complex_check>}}
```
(Only arguments with `ottr:IRI` inside the type string of an argument, are checked for complex types)

For every List in the requested type the code checks
1. if the requested List is a "Not-Empty-List" with:
```
{{#ifexpr: {{#arraysize:<value_ref>}} = 0
  | {{#if: <value_ref>|{{ottr:ErrorMsg|<error_text>|code=7|type=Warning}}|}}
  |<inner_complex_check>
}}
```
2. Adds a check for every element in the list:
```
{{#loop:type_list_test_<restricted_type_represenation>
  |0
  |{{#arraysize:<value_ref>}}
  |<inner_complex_check>
}}
```
3. Updates the `<value_ref>` to:
```
{{#explode:{{#arrayindex:<value_ref>|{{#var:type_list_test_<restricted_type_represenation>}}}}|;|0}}
```

Last, check, dependent on the existence of a LUB restriction, if the most inner iri is listed (as a page) in the category of the requested type:

- LUB:
```
{{#ifeq: {{ottr:checkLUBType|<value_ref>|<target_type>}}|NoMatch|<warningMsg>|}}
```
- Normal URI:
```
{{#ifeq: {{ottr:checkType|<value_ref>|<target_type>}}|NoMatch|<warningMsg>|}}
```
Where `target_type` is the (not replaced by `ottr:IRI`) most inner requested type.

The Template **ottr:checkType** contains:
```{{#ask:[[Category:{{{2}}}]][[{{{1}}}]]|default=NoMatch|format=list|link=none|mainlabel=-}}```
and **ottr:checkLUBType**:
```
{{#if: {{#pos:{{#ask:[[{{{1|}}}]]|?Category=|link=none|format=list|mainlabel=-}},|Category:{{ucfirst:{{{2|}}}}}}}|found|NoMatch}}
```
### Some Type Representations

The generated type strings for literals (also parsed by the ottr syntax) are:
```python
type_to_type_string = {
	LiteralType.RDFLIT: "xsd:string§rdfs:resource§",
	LiteralType.BOOL: "xsd:boolean§rdfs:resource§",
	LiteralType.INTEGER: "xsd:integer§xsd:float§rdfs:resource§",
	LiteralType.DECIMAL: "xsd:float§rdfs:resource§",
}
```
RDFLIT is the string type. Also Type Hints via `"some string text""^^<typeHint>` are also mapped by the above dictionary, with the keys:
```python
class LiteralType:
	INTEGER = "xsd:integer"
	DECIMAL = "xsd:float"
	BOOL = "xsd:boolean"
	RDFLIT = "xsd:string"
```
If they are equal.

The type string for an IRI is:
```python
"ottr:IRI§rdfs:resource§"
```
The type of a list is calculated by a template (`ottr:ListType`) with the content:
```
{{#if: {{{1|}}}
  |{{#arraydefine:mykey|{{{1}}}|,}}
   {{#arraydefine:incommonarray|{{#explode:{{#arrayindex:mykey|0}}|;|1}}|§}}
   {{#loop: idx
     |0
     |{{#arraysize:mykey}}
     |{{#arraydefine: i_array|{{#explode:{{#arrayindex:mykey|{{#var:idx}}}}|;|1}}|§}}
      {{#arrayintersect:incommonarray|incommonarray|i_array}}
   }}
   {{#loop: idx
     |0
     |{{#arraysize:incommonarray}}
     |{{#if: {{#arrayindex:incommonarray|{{#var:idx}}}}
       |List<{{#arrayindex:incommonarray|{{#var:idx}}}}>§
       |
     }}
   }}
   {{#arrayreset:mykey|incommonarray|i_array}}
  |
}}
```
It calculates the intersection of all types of all elements in a list.

## Lists
A list is an array.

The value and the type of an element of a list is separated by `;`.
Elements in a list are separated by `,`.
```
{{#arraydefine:<list_key>|<list_repr>|,}}
```
The list_key is `<call_occurence>_listkey_<list_counter>`
The type of a list is derived from the types of the elements, with an intersection of all type strings. Every result type is than put into `List'<'<type>'>'`

Elements of an array are accessed by `{{#arrayindex: <list_key>|{{#var: <loop_index>}} }}`
The value of an element with `xyz=0` and the type with `xyz=1` in `{{#explode:<element_repr>|;|xyz}}`

A template call with only one list expand is handled in the following way:
```
{{#loop: {{ottr:idx_key|{{{call_occurrence}}}_%i|0}}
  | 0 
  | {{#arraysize:<list_key>}}
  |{{<template_name><argument_string>}}
}}
```


### Cross
For every list a loop. Nesting loops inside `%%s`.
```
{{#loop:<idx_key> | 0 | {{#arraysize:<list_key>}}|%%s}}
```
In the template call, put all different idx_keys into the argument positions.

### ZipMin and ZipMax
Min / Max size stored in a variable:
```
{{#vardefine:{{ottr:end_var|{{{call_occurrence}}}_<call_position>}}|%s}}
```
where `%s` depends on the number of lists and calculates the min/max array size. See `get_min_max_size(array_keys, operator)` in [Utils.py](includes/OttrToSmwPython/Utils.py).
Optional in the future: Write extension for calculating min and max.
```
{{#loop: {{ottr:idx_key|{{{call_occurrence}}}_<call_position>|0}}
  | 0 
  |{{#var:{{ottr:end_var|{{{call_occurrence}}}_<call_position>}}}}
  |{{<template_name><argument_string>}}
}}
```

## Debug Information
All wiki code is inside:
`{{#ifexpr: {{ottr:DebugOnOFF}}|%s}}`

### Number Triples
Init:
```
{{#vardefine:ottr_triple_count|0}}
```
Inside a BASE template:
```
{{#vardefine: ottr_triple_count|{{#expr:{{#var:ottr_triple_count}} + 1}}}}
```
Display debug info:
```
{{#var:ottr_triple_count}}
```

### Used IRIs
Init:
```
{{#vardefine:ottr_used_iris|}}
```
3x inside a BASE template (for every argument):
```
{{#if: {{#pos:{{{ottr_arg_type_<arg_position>|}}}|ottr:IRI§}}|{{#vardefine: ottr_used_iris|{{#var:ottr_used_iris}}{{{<arg_position>|}}},}}}}
```
Display debug info:
```
{{#arraydefine:ottr_used_iris_set|{{#var: ottr_used_iris}}|,}}
{{#arrayunique:ottr_used_iris_set}}
{{#arraysize:ottr_used_iris_set}}
{{#arrayreset:ottr_used_iris_set}}
```

### Max Depth
Init:
```
{{#vardefine:ottr_max_depth|0}}
```
In every template:
```
{{#ifexpr: {{{call_depth}}} > {{#var:ottr_max_depth}}|{{#vardefine:ottr_max_depth|{{{call_depth}}}}}|}}
```
Display debug info:
```
{{#var:ottr_max_depth}}
```

### Used Templates
Init:
```
{{#vardefine:ottr_used_templates|}}
```
In every template:
```
{{#vardefine:ottr_used_templates|{{#var:ottr_used_templates}}<template_name>,}}
```
Display debug info:
```
{{#arraydefine:ottr_used_templates_set|{{#var:ottr_used_templates}}|,}}
{{#arrayunique:ottr_used_templates_set}}
{{#loop: ottr_used_templates_idx
  |0
  |{{#arraysize:ottr_used_templates_set}}
  |{{#ifexpr: {{#var:ottr_used_templates_idx}}|-|:-}} {{#arrayindex:ottr_used_templates_set|{{#var:ottr_used_templates_idx}}}}:  <b>{{#count:{{#var:%s}}|{{#arrayindex:ottr_used_templates_set|{{#var:ottr_used_templates_idx}}}},}}</b><br/>}}
{{#arrayreset:ottr_used_templates_set}}
```

## ax:Type and ax:SubClassOf Additional Code
Code that adds Category relationship or asks the user to do it on other pages.
## ax:Type
```
<includeonly>
{{#ifeq:{{FULLPAGENAME}}|{{ucfirst:{{{1|}}}}}|[[Category:{{{2|}}}]]|{{#ifeq:{{ottr:checkLUBType|{{{1|}}}|{{{2|}}}}}|NoMatch
|{{#ifexpr:{{Exists|{{{1|}}}}}|<i>For correct type checking add on page </i><b>[[{{{1|}}}]]: </b><code><nowiki>[[Category:</nowiki>{{{2|}}}]]</code><br/><br/>
|{{#tag:inputbox|
type=create
preload=ottr:SubCategoryTemplate
hidden=yes
inline=true
default={{{1|}}}
buttonlabel=Create Page {{{1}}} for correct type checking.
preloadparams[]={{{2|}}}
preloadparams[]=n instance
}}}}}}}}</includeonly>
```

### ax:SubClassOf
```
<includeonly>
{{#ifeq: {{#ask:[[Subcategory of::{{{2|}}}]]|link=none}}|Category:{{ucfirst:{{{1|}}}}}||{{#ifexpr:{{Exists|Category:{{{1}}}}}|<i>Please add </i><code><nowiki>[[Category:</nowiki>{{{2}}}]]</code><i> to page </i>[[:Category:{{{1}}}]]<i> for correct type checking.</i><br/><br/>
|{{#tag:inputbox|
type=create
preload=ottr:SubCategoryTemplate
hidden=yes
inline=true
default=Category:{{{1|}}}
buttonlabel=Create Category for correct type checking.
preloadparams[]={{{2|}}}
preloadparams[]= subclass
}}}}}}</includeonly>
```
