
package pass;

import java.lang.System;

public class ForLoop {

    public static void main(String[] args) {
        for(int i = 10; i>0; i--) {
            System.out.println(i);
        }

        int[] arr = {1, 2, 3, 4, 5};

        for (int i : arr) {
            System.out.println(i);
        }
    }




}
