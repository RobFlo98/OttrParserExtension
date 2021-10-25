import textwrap

from OTTRClassesForSMW import PrefixID, Template, Instance, SMWContext
from typing import List


class SMWGenerator:

	def __init__(self, prefixes: List[PrefixID], definitions: List[Template], instances: List[Instance]):
		self.prefixes = prefixes
		self.definitions = definitions
		self.instances = instances

	def produce_smw(self):
		"""Produce the valid SMW Code for the init arguments for a page in a wiki.

		This means produce all prefix code. Instances only if there are no template definitions.
		If there are template definitions produce only the first one. Add errors for instances outside a template and
		for input with more than one template definition.
		A call with only signature template definitions is handled as a form input and so produce only form relevant code.

		:return: Triple of strings containing the smw for the prefixes, instances and template_definitions
		"""
		prefixes = self.produce_prefixes()
		if prefixes:
			print(prefixes)
		instances = ""
		template_definitions = ""
		warnings = ""
		if len(self.instances) > 0 and len(self.definitions) == 0:
			instances = self.produce_instances()
			print(instances)
		elif len(self.definitions) > 0:
			templates_with_content = [d for d in self.definitions if d.pattern_list is not None]
			if len(self.instances) > 0:
				warnings = "{{ottr:ErrorMsg|No instances in a template allowed. Converting only the template|code=1|type=Warning}}"
			if len(templates_with_content) > 1:
				warnings = "{{ottr:ErrorMsg|Only ONE template definition per page and call. Converting only first template|code=2|type=Warning}}"
			if len(templates_with_content) > 0:
				self.definitions = templates_with_content[:1]
				produce_forms = False
			else:
				produce_forms = True
			if warnings:
				print(warnings)
			template_definitions = self.produce_templates(produce_forms)
			print(template_definitions)

		return prefixes, instances, template_definitions

	def produce_prefixes(self):
		return "".join([prefix.get_smw_repr() for prefix in self.prefixes])

	def produce_instances(self):
		smw_context = SMWContext()
		instance_string = ""
		for inst_pos, instance in enumerate(self.instances):
			smw_context.call_occurrence_position = inst_pos
			instance_string += instance.get_smw_repr(smw_context)
		return smw_context.produce_debug_str_start() + instance_string + smw_context.produce_debug_str_end() + smw_context.produce_triple_display() + "\n[[Category:OTTR_Instance]]"

	def produce_templates(self, produce_form):
		form_string = ""
		if produce_form:
			# all forms are multi instances with multi templates (brought about by more than one template signature in the input)
			form_string = textwrap.dedent("""\
			<div id="wikiPreview" style="display: none; padding-bottom: 25px; margin-bottom: 25px; border-bottom: 1px solid #AAAAAA;"></div>
			Add/Change here OTTR instances for the generated/edited page.<br/>
			<i>"?": optional argument, &emsp;"!": not a blank node ([] or _:example), &emsp; "DFLT": default value available</i> <br/>
			Add '''none''' or '''ottr:none''' for optional arguments or for arguments that should be replaced by the default value.
			{{{for template|ottr:MultiInstanceCreation}}}
			%s
			{{{field|default_form|hidden|default=%s}}}
			{{{end template}}}
			%%s
			<br/>
			<b>Free text:</b>
			
			{{{standard input|free text|rows=10}}}
			
			{{{standard input|summary}}}
			
			{{{standard input|minor edit}}} {{{standard input|watch}}}
			
			{{{standard input|save}}} {{{standard input|preview}}} {{{standard input|changes}}} {{{standard input|cancel}}}
			""") % ("".join([("{{{field|template_%i|holds template}}}" % i) for i in range(1, len(self.definitions) + 1)]), self.definitions[0].signature.template_name)

		for i, template in enumerate(self.definitions, start=1):
			if template.pattern_list is None:
				form_string = form_string % (template.get_form_repr(i, len(self.definitions) == 1) + "%s")
			else:
				smw_context = SMWContext()
				smw_context.call_occurrence_position = 0
				upper_template_name = (template.signature.template_name[:1].upper() + template.signature.template_name[1:]).replace("_", " ")
				# a check if the template is in the template namespace
				# and a check if the template name is the same as the page name (without the 'Template:'-Prefix) and throws an error otherwise
				return (("<noinclude>"
						"{{#ifeq:{{#pos:{{FULLPAGENAME}}|Template:}}|0|"
						"{{#ifeq:{{#sub:{{FULLPAGENAME}}|9}}|%s||"
						"{{ottr:ErrorMsg|Template name and Page name should be the same: %s (Template name), <b>{{#sub:{{FULLPAGENAME}}|9}}</b> (Pagename)|code=-1|type=Warning}}}}"
						"|{{ottr:ErrorMsg|Page does <b>NOT</b> lie in the <b>Template</b> namespace ({{FULLPAGENAME}})|code=-2|type=Warning}}}}"
						" </noinclude>" % (upper_template_name, upper_template_name))
					+ ("<noinclude>{{#ifexpr: {{ottr:DisplayFormHelp}}|%s|}}</noinclude>" % template.get_form_help_str())
					+ "<includeonly>"
					+ template.get_smw_repr(smw_context)
					+ "</includeonly><noinclude>[[Category:OTTR_Template]]</noinclude>")
		return form_string % ""


