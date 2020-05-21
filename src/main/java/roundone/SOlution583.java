package roundone;

import java.util.Arrays;

public class SOlution583 {

    class Solution {

        public int minDistance(String word1, String word2) {

            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return solution(word1, word2, word1.length(), word2.length(), dp);

        }

        //memoize
        private int solution(String word1, String word2, int i, int j, int[][] dp) {


            if (i == 0) {
                return j;

            }
            if (j == 0) {
                return i;
            }
            if (dp[i - 1][j - 1] != -1) {
                return dp[i - 1][j - 1];
            }
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                return dp[i - 1][j - 1] = solution(word1, word2, i - 1, j - 1, dp);
            }

            return dp[i - 1][j - 1] = min(solution(word1, word2, i, j - 1, dp) + 1, solution(word1, word2, i - 1, j, dp) + 1);

        }

        private int minDistance1(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j < word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i - 1][j - 1] = min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    }

                }

            }
            return dp[word1.length()][word2.length()];


        }


        private int min(int a, int b) {
            return Math.min(a, b);
        }
    }
}
