<?php
class SpecialOttrPages extends \SpecialPage {
	function __construct() {
		parent::__construct( 'OttrPages' );
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
        $wikitext = '==Ottr Templates==
'
        .'{{#ask:
[[dpm:+]]
[[Category:OTTR_Template]]
|?createdBy
|?usedBy
|format=table
}}' 
        .'
==OttrInstances==
'
        .'{{#ask:
[[Category:OTTR_Instance]]
|format=table
}}';
        $output->addWikiTextAsInterface( $wikitext );
	}
}
