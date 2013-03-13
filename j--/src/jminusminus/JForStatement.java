// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

import java.util.ArrayList;

/**
 * The AST node for a normal for-statement.
 */

class JForStatement extends JStatement {
	/** Initial expression */
	private JStatement init;
	
    /** Test expression. */
    private JExpression condition;

    /** Increment expression  */
    private JStatement incr;
    
    /** The body. */
    private ArrayList<JStatement> body;

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

    public JForStatement(int line, JStatement init, JExpression condition, JStatement incr, ArrayList<JStatement> body) {
        super(line);
        this.init = init;
        this.condition = condition;
        this.incr = incr;
        this.body = body;
    }

    /**
     * Analysis involves analyzing the test, checking its type and analyzing the
     * body statement.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JForStatement analyze(Context context) {
        init.analyze(context);
        condition.analyze(context);
        incr.analyze(context);
        for (JStatement statement : body) {
            statement.analyze(context);
        }
        condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        return this;
    }

    /**
     * Generate code for the normal for loop
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
        p.printf("<JForStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<InitializeExpression>\n");
        p.indentRight();
        init.writeToStdOut(p);
        p.indentLeft();
        p.printf("</InitializeExpression>\n");
        p.printf("<TestExpression>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        p.printf("<IncrementExpression>\n");
        p.indentRight();
        incr.writeToStdOut(p);
        p.indentLeft();
        p.printf("</IncrementExpression>\n");
        p.printf("<Body>\n");
        for (JStatement statement : body) {
            p.indentRight();
            statement.writeToStdOut(p);
            p.indentLeft();
        }
        p.printf("</Body>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");
    }

}
