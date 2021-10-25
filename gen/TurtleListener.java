// Generated from /home/florian/PycharmProjects/ottr-parser-for-smw/includes/OttrToSmwPython/stOTTR/Turtle.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TurtleParser}.
 */
public interface TurtleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TurtleParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(TurtleParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(TurtleParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#prefixID}.
	 * @param ctx the parse tree
	 */
	void enterPrefixID(TurtleParser.PrefixIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#prefixID}.
	 * @param ctx the parse tree
	 */
	void exitPrefixID(TurtleParser.PrefixIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#base}.
	 * @param ctx the parse tree
	 */
	void enterBase(TurtleParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#base}.
	 * @param ctx the parse tree
	 */
	void exitBase(TurtleParser.BaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#sparqlBase}.
	 * @param ctx the parse tree
	 */
	void enterSparqlBase(TurtleParser.SparqlBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#sparqlBase}.
	 * @param ctx the parse tree
	 */
	void exitSparqlBase(TurtleParser.SparqlBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#sparqlPrefix}.
	 * @param ctx the parse tree
	 */
	void enterSparqlPrefix(TurtleParser.SparqlPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#sparqlPrefix}.
	 * @param ctx the parse tree
	 */
	void exitSparqlPrefix(TurtleParser.SparqlPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(TurtleParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(TurtleParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(TurtleParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(TurtleParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#rdfLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRdfLiteral(TurtleParser.RdfLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#rdfLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRdfLiteral(TurtleParser.RdfLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#iri}.
	 * @param ctx the parse tree
	 */
	void enterIri(TurtleParser.IriContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#iri}.
	 * @param ctx the parse tree
	 */
	void exitIri(TurtleParser.IriContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#prefixedName}.
	 * @param ctx the parse tree
	 */
	void enterPrefixedName(TurtleParser.PrefixedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#prefixedName}.
	 * @param ctx the parse tree
	 */
	void exitPrefixedName(TurtleParser.PrefixedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#blankNode}.
	 * @param ctx the parse tree
	 */
	void enterBlankNode(TurtleParser.BlankNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#blankNode}.
	 * @param ctx the parse tree
	 */
	void exitBlankNode(TurtleParser.BlankNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#anon}.
	 * @param ctx the parse tree
	 */
	void enterAnon(TurtleParser.AnonContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#anon}.
	 * @param ctx the parse tree
	 */
	void exitAnon(TurtleParser.AnonContext ctx);
}