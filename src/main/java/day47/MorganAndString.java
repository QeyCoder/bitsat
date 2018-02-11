package day47;

import template.FastInputReader;

/**
 * Created by Gaurav on 10/02/18.
 */
public class MorganAndString {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int cases = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cases; i++) {
            String A = fastInputReader.readString();
            String B = fastInputReader.readString();

            stringBuilder.append((solution(A, B))).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static String solution(String a, String b) {
        int i = 0;
        int j = 0;

        StringBuilder stringBuilder
                = new StringBuilder();
        while (i < a.length() && j < a.length()) {

            if (a.charAt(i) < b.charAt(j)) {
                stringBuilder.append(a.charAt(i++));
            } else {
                stringBuilder.append(b.charAt(j++));
            }

        }

        for (int k = i; k < a.length(); k++) {
            stringBuilder.append(a.charAt(k));
        }
        for (int k = j; k < b.length(); k++) {
            stringBuilder.append(b.charAt(k));
        }
        return stringBuilder.toString();
    }
}
