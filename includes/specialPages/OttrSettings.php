<?php
class SpecialOttrSettings extends \SpecialPage {
	function __construct() {
		parent::__construct( 'OttrSettings' );
	}
    function getGroupName() {
        return 'ottr';
    }
	function execute( $par ) {
		$request = $this->getRequest();
		$output = $this->getOutput();
		$this->setHeaders();

		# Get request data from, e.g.
		$param = $request->getText( 'param' );

		# Do stuff
		# ...
        # Oh God ;( the formatting
        $wikitext ='==[[Template:Ottr:AllAnnotationsOnOff]]==
'
            .'The feature annotations from the OTTR-language are relevant for additional information about the template. So the first called template should get called. For ignoring such limitation and call every annotation of all called templates turn this ON. The extension uses the annotation also for specifying layout templates for a template (See [https://www.mediawiki.org/wiki/Help:Extension:OttrParser#Set_Layout_Template_via_Annotations here]).<br><br> '
            .'
==[[Template:ottr:DebugOnOFF]]==
'
            .'The extension provides some (debug) information about generated instances. This includes the \'\'number of initialised triples\'\', \'\'number of different used IRIs\'\' (an indication of the connectedness of the page), the \'\'max depth of OTTR-template calls\'\' and a list of all \'\'used OTTR-Templates\'\' and their \'\'number of calls\'\'.

\'\'Example Appearance:\'\'
<blockquote>
\'\'\'Debug Info:\'\'\'
* \'\'Number Init Triples:\'\' \'\'\'3\'\'\'
* \'\'Number Used IRIs:\'\' \'\'\'6\'\'\'
* \'\'Max Depth:\'\' \'\'\'2\'\'\'
* \'\'Used Templates:\'\'
:- ex:Template1: \'\'\'1\'\'\'<br/>- ottr:Triple: \'\'\'3\'\'\'
</blockquote>'
            .'
==[[Template:ottr:DisplayCode]]==

'
            .'Display the generated Wikicode for the instances or template on a page.

\'\'Example Appearance:\'\'
<blockquote>
\'\'\'Wikicode:\'\'\'
<pre>
{{#ifexpr: {{ottr:DebugOnOFF}}|{{#vardefine:ottr_triple_count|0}}{{#vardefine:ottr_used_iris|}}{{#vardefine:ottr_max_depth|0}}{{#vardefine:ottr_used_templates|}}}}{{ex:Template1|ex:TestPara1|ex:TestPara2|ex:TestPara3|ottr_arg_type_1=ottr:IRI§rdfs:resource|ottr_arg_type_2=ottr:IRI§rdfs:resource|ottr_arg_type_3=ottr:IRI§rdfs:resource|call_occurrence={{FULLPAGENAME}}_0|call_depth=1}}{{#ifexpr: {{ottr:DebugOnOFF}}|<b>Debug Info:</b>
* <i>Number Init Triples:</i> <b>{{#var:ottr_triple_count}}</b>
* <i>Number Used IRIs:</i> <b>{{#arraydefine:ottr_used_iris_set|{{#var: ottr_used_iris}}|,}}{{#arrayunique:ottr_used_iris_set}}{{#arraysize:ottr_used_iris_set}}{{#arrayreset:ottr_used_iris_set}}</b>
* <i>Max Depth:</i> <b>{{#var:ottr_max_depth}}</b>
* <i>Used Templates:</i>
{{#arraydefine:ottr_used_templates_set|{{#var:ottr_used_templates}}|,}}{{#arrayunique:ottr_used_templates_set}}{{#loop: ottr_used_templates_idx|0|{{#arraysize:ottr_used_templates_set}}|{{#ifexpr: {{#var:ottr_used_templates_idx}}|-|:-}} {{#arrayindex:ottr_used_templates_set|{{#var:ottr_used_templates_idx}}}}:  <b>{{#count:{{#var:ottr_used_templates}}|{{#arrayindex:ottr_used_templates_set|{{#var:ottr_used_templates_idx}}}},}}</b><br/>}}{{#arrayreset:ottr_used_templates_set}}
<nowiki/>
}}{{#ifexpr: {{ottr:DisplayTriplesOnOff}}|{{ottr:AskForTriples}}}}
</pre>
</blockquote>'
            .'
==[[Template:ottr:DisplayFormHelp]]==

'           
            .'</translate>
For easy creating forms and instances, the extension adds a text part to each template, that let the user use them. The default page for a form is the same name as the template, but in the Form namespace. With the InputBox extension a button links to the new page with the automated content that fits to the defined template. If the default page for a form exists, the button disappears and a link to the generated form appears, that expects the name of a page for new instances.

\'\'Example Appearance of a button to create a form page:\'\'
<blockquote>
\'\'\'Form Info:\'\'\'<br/>
The OTTR-Extension comes with an automated form creation, which simplifies the generation of instances of a template via input fields: 
<inputbox>
type=create
hidden=yes
default=Main Page
buttonlabel=Create Form
</inputbox>
</blockquote>

\'\'Example Appearance of a link to create an instance of the template:\'\'

<blockquote>
\'\'\'Form Info:\'\'\'<br/>
The OTTR Extension comes with an automated form creation, which simplifies the generation of instances of a template via input fields:

: [[Main Page|Create instance with form]]
</blockquote>'
            .'
==[[Template:ottr:DisplayOttr]]==

'
.'Display the formulated OTTR call outside the editing mode can be useful on the rendered page. Both for instances and template definitions.

\'\'Example Appearance:\'\'
<blockquote>
\'\'\'OTTR-Definition:\'\'\'
<pre>
 ex:Template1 [ ?arg1, ?arg2, ?arg3] :: {
     ottr:Triple (?arg1, ex:testPredicate, ex:testObject) ,
     ottr:Triple (ex:testSubject, ?arg2, ex:testObject) ,
     ottr:Triple (ex:testSubject, ex:testPredicate, ?arg3)
 } .
</pre>
</blockquote>'
        .'
==[[Template:ottr:DisplayTriplesOnOff]]==

'
        .'Include an inline ask query about the triples defined on this page. Needs sometimes more refreshes for displaying the table.

\'\'Example Appearance:\'\'
<blockquote>
\'\'\'Generated Triples:\'\'\' \'\'(Needs sometimes 2x refreshes)\'\'
<table class="sortable wikitable smwtable jquery-tablesorter"><tr><th class="headerSort" tabindex="0" role="columnheader button" title="Sort ascending">&nbsp;</th><th class="Subject headerSort" tabindex="0" role="columnheader button" title="Sort ascending"><span style="color:#4371cf;">Subject</span></th><th class="Predicate headerSort" tabindex="0" role="columnheader button" title="Sort ascending"><span style="color:#4371cf;">Predicate</span></th><th class="Object headerSort" tabindex="0" role="columnheader button" title="Sort ascending"><span style="color:#4371cf;">Object</span></th></tr><tr data-row-number="1" class="row-odd"><td class="smwtype_wpg"><span class="smw-subobject-entity" style="color:#2a4b8d">ExampleInstances:Template1</span></td><td class="Subject smwtype_wpg"><span style="color:#dd3333;">Ex:TestPara1</span></td><td class="Predicate smwtype_wpg"><span style="color:#dd3333;">Ex:testPredicate</span></td><td class="Object smwtype_wpg"><span style="color:#dd3333;">Ex:testObject</span></td></tr><tr data-row-number="2" class="row-even"><td class="smwtype_wpg"><span class="smw-subobject-entity" style="color:#2a4b8d;">ExampleInstances:Template1</span></td><td class="Subject smwtype_wpg"><span style="color:#dd3333;">Ex:testSubject</span></td><td class="Predicate smwtype_wpg"><span style="color:#dd3333;">Ex:testPredicate</span></td><td class="Object smwtype_wpg"><span style="color:#dd3333;">Ex:TestPara3</span></td></tr><tr data-row-number="3" class="row-odd"><td class="smwtype_wpg"><span class="smw-subobject-entity" style="color:#2a4b8d">ExampleInstances:Template1</span></td><td class="Subject smwtype_wpg"><span style="color:#dd3333;">Ex:testSubject</span></td><td class="Predicate smwtype_wpg"><span style="color:#dd3333;">Ex:TestPara2</span></td><td class="Object smwtype_wpg"><span style="color:#dd3333;">Ex:testObject</span></td></tr></table>
</blockquote>
';
		$output->addWikiTextAsInterface( $wikitext );
	}
}
