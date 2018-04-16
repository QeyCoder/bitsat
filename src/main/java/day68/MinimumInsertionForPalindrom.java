package day68;

import template.FastInputReader;

/**
 * Created by Gaurav on 14/04/18.
 */


public class MinimumInsertionForPalindrom {


    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            String ip = fastInputReader.readString();
            stringBuilder.append(solution(ip.toCharArray(), 0, ip.length() - 1)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(char[] input, int i, int j) {
        if (i > j) {
            return Integer.MAX_VALUE;
        }
        if (i == j) {
            return 0;
        }

        if (i == j - 1) {
            if (input[i] == input[j]) {
                return 0;
            } else {
                return 1;
            }
        }
        return (input[i] == input[j]) ? solution(input, i + 1, j - 1) : (Integer.min(solution(input, i, j - 1), solution(input, i + 1, j)) + 1);

    }


}
