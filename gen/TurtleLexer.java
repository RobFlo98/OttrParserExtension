// Generated from /home/florian/PycharmProjects/ottr-parser-for-smw/includes/OttrToSmwPython/stOTTR/Turtle.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TurtleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, BooleanLiteral=9, 
		String=10, IRIREF=11, PNAME_NS=12, PNAME_LN=13, BLANK_NODE_LABEL=14, LANGTAG=15, 
		INTEGER=16, DECIMAL=17, DOUBLE=18, EXPONENT=19, STRING_LITERAL_QUOTE=20, 
		STRING_LITERAL_SINGLE_QUOTE=21, STRING_LITERAL_LONG_SINGLE_QUOTE=22, STRING_LITERAL_LONG_QUOTE=23, 
		UCHAR=24, ECHAR=25, WS=26, PN_CHARS_BASE=27, PN_CHARS_U=28, PN_CHARS=29, 
		PN_PREFIX=30, PN_LOCAL=31, PLX=32, PERCENT=33, HEX=34, PN_LOCAL_ESC=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "BooleanLiteral", 
			"String", "IRIREF", "PNAME_NS", "PNAME_LN", "BLANK_NODE_LABEL", "LANGTAG", 
			"INTEGER", "DECIMAL", "DOUBLE", "EXPONENT", "STRING_LITERAL_QUOTE", "STRING_LITERAL_SINGLE_QUOTE", 
			"STRING_LITERAL_LONG_SINGLE_QUOTE", "STRING_LITERAL_LONG_QUOTE", "UCHAR", 
			"ECHAR", "WS", "PN_CHARS_BASE", "PN_CHARS_U", "PN_CHARS", "PN_PREFIX", 
			"PN_LOCAL", "PLX", "PERCENT", "HEX", "PN_LOCAL_ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@prefix'", "'.'", "'@base'", "'BASE'", "'PREFIX'", "'^^'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "BooleanLiteral", 
			"String", "IRIREF", "PNAME_NS", "PNAME_LN", "BLANK_NODE_LABEL", "LANGTAG", 
			"INTEGER", "DECIMAL", "DOUBLE", "EXPONENT", "STRING_LITERAL_QUOTE", "STRING_LITERAL_SINGLE_QUOTE", 
			"STRING_LITERAL_LONG_SINGLE_QUOTE", "STRING_LITERAL_LONG_QUOTE", "UCHAR", 
			"ECHAR", "WS", "PN_CHARS_BASE", "PN_CHARS_U", "PN_CHARS", "PN_PREFIX", 
			"PN_LOCAL", "PLX", "PERCENT", "HEX", "PN_LOCAL_ESC"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public TurtleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Turtle.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u0188\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nv\n\n"+
		"\3\13\3\13\3\13\3\13\5\13|\n\13\3\f\3\f\3\f\7\f\u0081\n\f\f\f\16\f\u0084"+
		"\13\f\3\f\3\f\3\r\5\r\u0089\n\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u0095\n\17\3\17\3\17\7\17\u0099\n\17\f\17\16\17\u009c"+
		"\13\17\3\17\5\17\u009f\n\17\3\20\3\20\6\20\u00a3\n\20\r\20\16\20\u00a4"+
		"\3\20\3\20\6\20\u00a9\n\20\r\20\16\20\u00aa\7\20\u00ad\n\20\f\20\16\20"+
		"\u00b0\13\20\3\21\5\21\u00b3\n\21\3\21\6\21\u00b6\n\21\r\21\16\21\u00b7"+
		"\3\22\5\22\u00bb\n\22\3\22\7\22\u00be\n\22\f\22\16\22\u00c1\13\22\3\22"+
		"\3\22\6\22\u00c5\n\22\r\22\16\22\u00c6\3\23\5\23\u00ca\n\23\3\23\6\23"+
		"\u00cd\n\23\r\23\16\23\u00ce\3\23\3\23\7\23\u00d3\n\23\f\23\16\23\u00d6"+
		"\13\23\3\23\3\23\3\23\6\23\u00db\n\23\r\23\16\23\u00dc\3\23\3\23\6\23"+
		"\u00e1\n\23\r\23\16\23\u00e2\3\23\5\23\u00e6\n\23\3\24\3\24\5\24\u00ea"+
		"\n\24\3\24\6\24\u00ed\n\24\r\24\16\24\u00ee\3\25\3\25\3\25\3\25\7\25\u00f5"+
		"\n\25\f\25\16\25\u00f8\13\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u0100"+
		"\n\26\f\26\16\26\u0103\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\5\27\u010e\n\27\3\27\3\27\3\27\5\27\u0113\n\27\7\27\u0115\n\27\f\27"+
		"\16\27\u0118\13\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0125\n\30\3\30\3\30\3\30\5\30\u012a\n\30\7\30\u012c\n\30\f\30"+
		"\16\30\u012f\13\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u0149\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\5\35\u0156\n\35\3\36\3\36\5\36\u015a\n\36\3\37\3\37\3\37\7\37\u015f\n"+
		"\37\f\37\16\37\u0162\13\37\3\37\5\37\u0165\n\37\3 \3 \3 \5 \u016a\n \3"+
		" \3 \3 \7 \u016f\n \f \16 \u0172\13 \3 \3 \3 \5 \u0177\n \5 \u0179\n "+
		"\3!\3!\5!\u017d\n!\3\"\3\"\3\"\3\"\3#\5#\u0184\n#\3$\3$\3$\2\2%\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%\3\2\23\n\2\2\"$$>>@@^^``bb}\177\3\2\62;\4\2C\\c|\5\2\62;C\\"+
		"c|\4\2--//\4\2GGgg\6\2\f\f\17\17$$^^\6\2\f\f\17\17))^^\4\2))^^\4\2$$^"+
		"^\n\2$$))^^ddhhppttvv\5\2\13\f\17\17\"\"\17\2C\\c|\u00c2\u00d8\u00da\u00f8"+
		"\u00fa\u0301\u0372\u037f\u0381\u2001\u200e\u200f\u2072\u2191\u2c02\u2ff1"+
		"\u3003\ud801\uf902\ufdd1\ufdf2\uffff\7\2//\62;\u00b9\u00b9\u0302\u0371"+
		"\u2041\u2042\4\2\60\60<<\5\2\62;CHch\t\2##%\61==??ABaa\u0080\u0080\2\u01c2"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\3I\3\2\2\2\5Q\3\2\2\2\7S\3\2\2\2\tY\3\2\2\2\13^\3\2\2\2\re\3\2\2\2"+
		"\17h\3\2\2\2\21j\3\2\2\2\23u\3\2\2\2\25{\3\2\2\2\27}\3\2\2\2\31\u0088"+
		"\3\2\2\2\33\u008c\3\2\2\2\35\u008f\3\2\2\2\37\u00a0\3\2\2\2!\u00b2\3\2"+
		"\2\2#\u00ba\3\2\2\2%\u00c9\3\2\2\2\'\u00e7\3\2\2\2)\u00f0\3\2\2\2+\u00fb"+
		"\3\2\2\2-\u0106\3\2\2\2/\u011d\3\2\2\2\61\u0148\3\2\2\2\63\u014a\3\2\2"+
		"\2\65\u014d\3\2\2\2\67\u0151\3\2\2\29\u0155\3\2\2\2;\u0159\3\2\2\2=\u015b"+
		"\3\2\2\2?\u0169\3\2\2\2A\u017c\3\2\2\2C\u017e\3\2\2\2E\u0183\3\2\2\2G"+
		"\u0185\3\2\2\2IJ\7B\2\2JK\7r\2\2KL\7t\2\2LM\7g\2\2MN\7h\2\2NO\7k\2\2O"+
		"P\7z\2\2P\4\3\2\2\2QR\7\60\2\2R\6\3\2\2\2ST\7B\2\2TU\7d\2\2UV\7c\2\2V"+
		"W\7u\2\2WX\7g\2\2X\b\3\2\2\2YZ\7D\2\2Z[\7C\2\2[\\\7U\2\2\\]\7G\2\2]\n"+
		"\3\2\2\2^_\7R\2\2_`\7T\2\2`a\7G\2\2ab\7H\2\2bc\7K\2\2cd\7Z\2\2d\f\3\2"+
		"\2\2ef\7`\2\2fg\7`\2\2g\16\3\2\2\2hi\7]\2\2i\20\3\2\2\2jk\7_\2\2k\22\3"+
		"\2\2\2lm\7v\2\2mn\7t\2\2no\7w\2\2ov\7g\2\2pq\7h\2\2qr\7c\2\2rs\7n\2\2"+
		"st\7u\2\2tv\7g\2\2ul\3\2\2\2up\3\2\2\2v\24\3\2\2\2w|\5)\25\2x|\5+\26\2"+
		"y|\5-\27\2z|\5/\30\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|\26\3\2\2"+
		"\2}\u0082\7>\2\2~\u0081\n\2\2\2\177\u0081\5\61\31\2\u0080~\3\2\2\2\u0080"+
		"\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7@\2\2\u0086\30"+
		"\3\2\2\2\u0087\u0089\5=\37\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\7<\2\2\u008b\32\3\2\2\2\u008c\u008d\5\31\r"+
		"\2\u008d\u008e\5? \2\u008e\34\3\2\2\2\u008f\u0090\7a\2\2\u0090\u0091\7"+
		"<\2\2\u0091\u0094\3\2\2\2\u0092\u0095\59\35\2\u0093\u0095\t\3\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u009e\3\2\2\2\u0096\u0099\5;"+
		"\36\2\u0097\u0099\7\60\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009d\u009f\5;\36\2\u009e\u009a\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\36\3\2\2\2\u00a0\u00a2\7B\2\2\u00a1\u00a3\t\4\2\2"+
		"\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00ae\3\2\2\2\u00a6\u00a8\7/\2\2\u00a7\u00a9\t\5\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af \3\2\2\2\u00b0\u00ae\3\2\2\2"+
		"\u00b1\u00b3\t\6\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5"+
		"\3\2\2\2\u00b4\u00b6\t\3\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\"\3\2\2\2\u00b9\u00bb\t\6\2\2"+
		"\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bf\3\2\2\2\u00bc\u00be"+
		"\t\3\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\7\60"+
		"\2\2\u00c3\u00c5\t\3\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7$\3\2\2\2\u00c8\u00ca\t\6\2\2"+
		"\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00e5\3\2\2\2\u00cb\u00cd"+
		"\t\3\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d4\7\60\2\2\u00d1\u00d3\t"+
		"\3\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00e6\5\'"+
		"\24\2\u00d8\u00da\7\60\2\2\u00d9\u00db\t\3\2\2\u00da\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00e6\5\'\24\2\u00df\u00e1\t\3\2\2\u00e0\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00e6\5\'\24\2\u00e5\u00cc\3\2\2\2\u00e5\u00d8\3\2\2\2\u00e5"+
		"\u00e0\3\2\2\2\u00e6&\3\2\2\2\u00e7\u00e9\t\7\2\2\u00e8\u00ea\t\6\2\2"+
		"\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00ed"+
		"\t\3\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef(\3\2\2\2\u00f0\u00f6\7$\2\2\u00f1\u00f5\n\b\2\2\u00f2"+
		"\u00f5\5\63\32\2\u00f3\u00f5\5\61\31\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2"+
		"\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7$"+
		"\2\2\u00fa*\3\2\2\2\u00fb\u0101\7)\2\2\u00fc\u0100\n\t\2\2\u00fd\u0100"+
		"\5\63\32\2\u00fe\u0100\5\61\31\2\u00ff\u00fc\3\2\2\2\u00ff\u00fd\3\2\2"+
		"\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7)\2\2\u0105"+
		",\3\2\2\2\u0106\u0107\7)\2\2\u0107\u0108\7)\2\2\u0108\u0109\7)\2\2\u0109"+
		"\u0116\3\2\2\2\u010a\u010e\7)\2\2\u010b\u010c\7)\2\2\u010c\u010e\7)\2"+
		"\2\u010d\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0112"+
		"\3\2\2\2\u010f\u0113\n\n\2\2\u0110\u0113\5\63\32\2\u0111\u0113\5\61\31"+
		"\2\u0112\u010f\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\u0115"+
		"\3\2\2\2\u0114\u010d\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\7)"+
		"\2\2\u011a\u011b\7)\2\2\u011b\u011c\7)\2\2\u011c.\3\2\2\2\u011d\u011e"+
		"\7$\2\2\u011e\u011f\7$\2\2\u011f\u0120\7$\2\2\u0120\u012d\3\2\2\2\u0121"+
		"\u0125\7$\2\2\u0122\u0123\7$\2\2\u0123\u0125\7$\2\2\u0124\u0121\3\2\2"+
		"\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0129\3\2\2\2\u0126\u012a"+
		"\n\13\2\2\u0127\u012a\5\63\32\2\u0128\u012a\5\61\31\2\u0129\u0126\3\2"+
		"\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u012c\3\2\2\2\u012b"+
		"\u0124\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7$\2\2\u0131"+
		"\u0132\7$\2\2\u0132\u0133\7$\2\2\u0133\60\3\2\2\2\u0134\u0135\7^\2\2\u0135"+
		"\u0136\7w\2\2\u0136\u0137\3\2\2\2\u0137\u0138\5E#\2\u0138\u0139\5E#\2"+
		"\u0139\u013a\5E#\2\u013a\u013b\5E#\2\u013b\u0149\3\2\2\2\u013c\u013d\7"+
		"^\2\2\u013d\u013e\7W\2\2\u013e\u013f\3\2\2\2\u013f\u0140\5E#\2\u0140\u0141"+
		"\5E#\2\u0141\u0142\5E#\2\u0142\u0143\5E#\2\u0143\u0144\5E#\2\u0144\u0145"+
		"\5E#\2\u0145\u0146\5E#\2\u0146\u0147\5E#\2\u0147\u0149\3\2\2\2\u0148\u0134"+
		"\3\2\2\2\u0148\u013c\3\2\2\2\u0149\62\3\2\2\2\u014a\u014b\7^\2\2\u014b"+
		"\u014c\t\f\2\2\u014c\64\3\2\2\2\u014d\u014e\t\r\2\2\u014e\u014f\3\2\2"+
		"\2\u014f\u0150\b\33\2\2\u0150\66\3\2\2\2\u0151\u0152\t\16\2\2\u01528\3"+
		"\2\2\2\u0153\u0156\5\67\34\2\u0154\u0156\7a\2\2\u0155\u0153\3\2\2\2\u0155"+
		"\u0154\3\2\2\2\u0156:\3\2\2\2\u0157\u015a\59\35\2\u0158\u015a\t\17\2\2"+
		"\u0159\u0157\3\2\2\2\u0159\u0158\3\2\2\2\u015a<\3\2\2\2\u015b\u0164\5"+
		"\67\34\2\u015c\u015f\5;\36\2\u015d\u015f\7\60\2\2\u015e\u015c\3\2\2\2"+
		"\u015e\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0165\5;\36\2\u0164"+
		"\u0160\3\2\2\2\u0164\u0165\3\2\2\2\u0165>\3\2\2\2\u0166\u016a\59\35\2"+
		"\u0167\u016a\4\62<\2\u0168\u016a\5A!\2\u0169\u0166\3\2\2\2\u0169\u0167"+
		"\3\2\2\2\u0169\u0168\3\2\2\2\u016a\u0178\3\2\2\2\u016b\u016f\5;\36\2\u016c"+
		"\u016f\t\20\2\2\u016d\u016f\5A!\2\u016e\u016b\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171\u0176\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0177\5;"+
		"\36\2\u0174\u0177\7<\2\2\u0175\u0177\5A!\2\u0176\u0173\3\2\2\2\u0176\u0174"+
		"\3\2\2\2\u0176\u0175\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0170\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179@\3\2\2\2\u017a\u017d\5C\"\2\u017b\u017d\5G$\2\u017c"+
		"\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017dB\3\2\2\2\u017e\u017f\7\'\2\2"+
		"\u017f\u0180\5E#\2\u0180\u0181\5E#\2\u0181D\3\2\2\2\u0182\u0184\t\21\2"+
		"\2\u0183\u0182\3\2\2\2\u0184F\3\2\2\2\u0185\u0186\7^\2\2\u0186\u0187\t"+
		"\22\2\2\u0187H\3\2\2\2\63\2u{\u0080\u0082\u0088\u0094\u0098\u009a\u009e"+
		"\u00a4\u00aa\u00ae\u00b2\u00b7\u00ba\u00bf\u00c6\u00c9\u00ce\u00d4\u00dc"+
		"\u00e2\u00e5\u00e9\u00ee\u00f4\u00f6\u00ff\u0101\u010d\u0112\u0116\u0124"+
		"\u0129\u012d\u0148\u0155\u0159\u015e\u0160\u0164\u0169\u016e\u0170\u0176"+
		"\u0178\u017c\u0183\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}