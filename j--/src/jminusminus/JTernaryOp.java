
package jminusminus;

import static jminusminus.CLConstants.*;

public class JTernaryOp extends JExpression{

    /**
     * Construct an AST node for a ternary expression given its
     * line number, and the lhs and rhs operands.
     * 
     * @param line
     *            line in which the ternary expression occurs in
     *            the source file.
     * @param condition
     *            Condition operand.
     * @param vTrue
     *            vTrue operand.
     * @param vFalse
     * 			  vFalse operand.
     */
	private String operator;
	private JExpression condition;
	private JExpression vTrue;
	private JExpression vFalse;
	
    public JTernaryOp(int line, JExpression condition, JExpression vTrue, JExpression vFalse) {
        super(line);
        this.operator = "?";
        this.condition = condition;
        this.vTrue = vTrue;
        this.vFalse = vFalse;
    }


    /**
     * The analysis of a ternary operation consists of analyzing its left
     * operand, and making sure it has the type BOOLEAN.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */
	public JExpression analyze(Context context) {
		condition = (JExpression) condition.analyze(context);
		vTrue = (JExpression) vTrue.analyze(context);
		vFalse = (JExpression) vFalse.analyze(context);
		condition.type().mustMatchExpected(line(), Type.BOOLEAN);
		vTrue.type().mustMatchExpected(line(),vFalse.type());
		type = vTrue.type();
        return this;
	}

	@Override
	public void codegen(CLEmitter output) {
        //TODO
	}


	/**
     * @inheritDoc
     */
	public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTernaryOp line=\"%d\" type=\"%s\" "
                + "operator=\"%s\">\n", line(), ((type == null) ? "" : type
                .toString()), Util.escapeSpecialXMLChars(operator));
        p.indentRight();
        p.printf("<Condition>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Condition>\n");
        p.printf("<ValueTrue>\n");
        p.indentRight();
        vTrue.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ValueTrue>\n");
        p.printf("<ValueFalse>\n");
        p.indentRight();
        vFalse.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ValueFalse>\n");
        p.indentLeft();
        p.printf("</JTernaryOp>\n");
    }
}
