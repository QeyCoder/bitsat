package roundzero.day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 05/11/17.
 */
public class RemoveDuplicate {


    static String super_reduced_string(String s) {

        for (int i = 0; i < s.length() - 1; i++) {

            char a = s.charAt(i);
            char b = s.charAt(i + 1);

            if (a == b) {
                s = s.substring(0, i) + s.substring(i + 2);
                i = -1;
            }


        }

        return s.length()>1?s:"Empty String";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
