#SMW include 
wfLoadExtension( 'SemanticMediaWiki' );
enableSemantics( 'localhost/mediawiki-1.37.1' );

# OTTR extension

wfLoadExtension( 'OttrParserExtension' );
# OTTR extension dependencies

wfLoadExtension( 'ParserFunctions' );
$wgPFEnableStringFunctions = true;
wfLoadExtension( 'Loops' );
wfLoadExtension( 'Arrays' );
wfLoadExtension( 'PageForms' );
wfLoadExtension( 'InputBox' );
wfLoadExtension( 'Variables' );

require_once "$IP/extensions/AutoCreatePage/AutoCreatePage.php";


