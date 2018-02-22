package day55;

import template.FastInputReader;
import template.MiscUtils;

/**
 * Created by Gaurav on 22/02/18.
 */
public class LongestRepeatingSubSequence {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {


            int size = fastInputReader.readInt();
            String input = fastInputReader.readString();
            stringBuilder.append(solution(input, size)).append("\n");

        }
        System.out.println(stringBuilder.toString());
    }

    private static int solution(String input, int size) {


        int[][] dp = new int[size + 1][size + 1];


        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {

                if (input.charAt(i - 1) == input.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = MiscUtils.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }


        }
        return dp[size][size];
    }
}
