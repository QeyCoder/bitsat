package day59;

import template.FastInputReader;

/**
 * Created by Gaurav on 04/03/18.
 */


public class StringReduction {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            String ipStr = fastInputReader.readString();
            stringBuilder.append(solution(ipStr)).append("\n");
        }
        System.out.println(stringBuilder);
    }
//trick solution
    private static int solution(String chars) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < chars.length(); i++) {
            if (chars.charAt(i) == 'a') {
                a++;
            }
            if (chars.charAt(i) == 'b') {
                b++;
            }
            if (chars.charAt(i) == 'c') {
                c++;
            }
        }
        if (a == 0 && b == 0) {
            return c;
        }

        if (a == 0 && c == 0) {
            return b;
        }

        if (c == 0 && b == 0) {
            return a;
        }
        if ((a % 2 == 0 && b % 2 == 0 && c % 2 == 0) || (a % 2 != 0 && b % 2 != 0 && c % 2 != 0)) {
            return 2;
        }
        return 1;

    }


}
