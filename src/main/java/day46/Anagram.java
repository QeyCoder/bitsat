package day46;

import template.FastInputReader;

/**
 * Created by Gaurav on 08/02/18.
 */
public class Anagram {


    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        StringBuilder stringBuilder
                = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String data = fastInputReader.readString();
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(String data) {
        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < data.length() / 2; i++) {
            a[data.charAt(i) - 'a']++;
        }

        for (int i = data.length() / 2; i < data.length(); i++) {
            b[data.charAt(i) - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            int val = a[i] - b[i];
            if (val < 0) {
                val = -val;
            }
            sum += val;
        }

        if (sum % 2 == 0) {
            return sum / 2;
        } else {
            return -1;
        }


    }

}
