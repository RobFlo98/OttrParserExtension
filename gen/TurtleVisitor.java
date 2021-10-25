// Generated from /home/florian/PycharmProjects/ottr-parser-for-smw/includes/OttrToSmwPython/stOTTR/Turtle.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TurtleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TurtleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TurtleParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(TurtleParser.DirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#prefixID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixID(TurtleParser.PrefixIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase(TurtleParser.BaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#sparqlBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSparqlBase(TurtleParser.SparqlBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#sparqlPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSparqlPrefix(TurtleParser.SparqlPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(TurtleParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(TurtleParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#rdfLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRdfLiteral(TurtleParser.RdfLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#iri}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIri(TurtleParser.IriContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#prefixedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixedName(TurtleParser.PrefixedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#blankNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankNode(TurtleParser.BlankNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#anon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnon(TurtleParser.AnonContext ctx);
}