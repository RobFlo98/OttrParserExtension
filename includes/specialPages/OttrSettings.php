<?php
class SpecialOttrSettings extends \SpecialPage {
	function __construct() {
		parent::__construct( 'OttrSettings' );
	}

	function execute( $par ) {
		$request = $this->getRequest();
		$output = $this->getOutput();
		$this->setHeaders();

		# Get request data from, e.g.
		$param = $request->getText( 'param' );

		# Do stuff
		# ...
        $wikitext = 'Change OttrParserExtension Settings:<br><br>'
            
            .'[[Template:Ottr:AllAnnotationsOnOff]]<br>'
            .'[[Template:ottr:DebugOnOFF]]<br>'
            .'[[Template:ottr:DisplayCode]]<br>'
            .'[[Template:ottr:DisplayFormHelp]]<br>'
            .'[[Template:ottr:DisplayOttr]]<br>'
            .'[[Template:ottr:DisplayTriplesOnOff]]<br>';
		$output->addWikiTextAsInterface( $wikitext );
	}
}
