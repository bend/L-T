// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

import java.util.ArrayList;

/**
 * The AST node for a while-statement.
 */

class JForEnhancedStatement extends JStatement {
	/** Initial expression */
	//	private JStatement identifier;

	/** Test expression. */
	//	private JExpression expression;


	/** Initial expression */
	private JStatement init;

	/** Test expression. */
	private JExpression condition;

	/** Increment expression  */
	private JStatement incr;

	/** The body. */
	private JStatement body;


	/**
	 * Construct an AST node for a while-statement given its line number, the
	 * test expression, and the body.
	 * 
	 * @param line
	 *            line in which the while-statement occurs in the source file.
	 * @param condition
	 *            test expression.
	 * @param body
	 *            the body.
	 */

	public JForEnhancedStatement(int line, JStatement init, JExpression condition, JStatement body) {
		super(line);
		//this.identifier = init;
		//this.expression = condition;
		//this.body = body;


		// Gestion du FOR Normal


		//INIT
/*		
		ArrayList<JVariableDeclarator> vars = new ArrayList<JVariableDeclarator>();

		JVariable ourI = new JVariable(line,"i");
		ourI.type = Type.INT;
	

		JVariableDeclarator var = new JVariableDeclarator(line,ourI.name(),ourI.type,new JLiteralInt(line,"0"));
		vars.add(var);

		JStatement initFor = new JVariableDeclaration(line,new ArrayList<String>(),vars);


		//CONDITION
		JBinaryExpression condFor = new JGreaterThanOp(line,new JLiteralInt(line,"4"),ourI);

		//incr expression
		JStatement incr = new JAssignOp(line,new JVariable(line,"i"),new JPlusOp(line,new JLiteralInt(line,"5"),new JLiteralInt(line,"1")));
		

		ArrayList<JStatement> statements = new ArrayList<JStatement>();
		statements.add(incr);
		statements.add(body);
		JStatement ourBody = new JBlock(line,statements);


		this.init = initFor;
		this.condition = condFor;
		this.body = ourBody;


*/

	}

	/**
	 * Analysis involves analyzing the test, checking its type and analyzing the
	 * body statement.
	 * 
	 * @param context
	 *            context in which names are resolved.
	 * @return the analyzed (and possibly rewritten) AST subtree.
	 */

	public JForEnhancedStatement analyze(Context context) {
        /*
		init.analyze(context);
		condition.analyze(context);
		body.analyze(context);
		condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        */
		return this;
	}

	/**
	 * Generate code for the for loop.
	 * 
	 * @param output
	 *            the code emitter (basically an abstraction for producing the
	 *            .class file).
	 */

	public void codegen(CLEmitter output) {
	}

	/**
	 * @inheritDoc
	 */

	public void writeToStdOut(PrettyPrinter p) {
		//		p.printf("<JForEnhancedStatement line=\"%d\">\n", line());
		//		p.indentRight();$
		//		p.printf("<InitializeExpression>\n");
		//		p.indentRight();
		//		identifier.writeToStdOut(p);
		//		p.indentLeft();
		//		p.printf("</InitializeExpression>\n");
				p.printf("<Body>\n");
				p.indentRight();
				body.writeToStdOut(p);
				p.indentLeft();
				p.printf("</Body>\n");
		//		p.indentLeft();
		//		p.printf("</JForEnhancedStatement>\n");

	}

}
