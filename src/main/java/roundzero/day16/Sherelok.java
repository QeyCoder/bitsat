package roundzero.day16;

import java.util.Scanner;

public class Sherelok {

    static String isValid(String s) {

        int[] ints = new int[26];
        for (int i =0 ; i < s.length(); i++) {
            ints[s.charAt(i)-97 ]++;
        }

        for (int i = 1; i < ints.length; i++) {


        }
        return "YES";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
