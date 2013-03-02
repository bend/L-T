
package pass;

import java.lang.System;

public class MultiLinesComments {

    public static void main(String[] args) {
        // test
        /* This is a multi lines comment */
        /* This is another on
         * on multiple
         * //// ****
         * lines
         */
        System.out.println(/*This is a comment inside a function call */ "MultiLinesComments OK");
        //System.out.println("OK");
    }

}
