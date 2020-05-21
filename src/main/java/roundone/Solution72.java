package roundone;

import java.util.Arrays;

public class Solution72 {
    static class Solution {
        public int minDistance1(String word1, String word2) {
            int[][] arr = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = i;
            }
            for (int j = 0; j < arr[0].length; j++) {
                arr[0][j] = j;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        //replace.
                        int replaceCount = 1 + arr[i - 1][j - 1];
                        //delete.
                        int deleteCount = 1 + arr[i - 1][j];
                        //add.
                        int addCount = 1 + arr[i][j - 1];
                        arr[i][j] = Math.min(replaceCount, Math.min(deleteCount, addCount));
                    } else {
                        arr[i][j] = arr[i - 1][j - 1];
                    }
                }
            }

            return arr[word1.length()][word2.length()];
        }

        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            for (int k = 0; k < dp.length; k++) {
                dp[k][0] = k;
            }

            for (int k = 0; k < dp[0].length; k++) {
                dp[0][k] = k;
            }


            for (int k = 1; k <= word1.length(); k++) {
                for (int l = 1; l <= word2.length(); l++) {
                    if (word1.charAt(k - 1) == word2.charAt(l - 1)) {
                        dp[k][l] = dp[k - 1][l - 1];
                    } else {
                        dp[k][l] = 1 + min(dp[k - 1][l], dp[k][l - 1], dp[k - 1][l - 1]);
                    }

                }

            }

            return dp[word1.length()][word2.length()];

        }

        private int solution1(String word1, String word2, int i, int j, int[][] dp) {

            for (int k = 0; k < i; k++) {
                dp[k][0] = k;
            }

            for (int k = 0; k < j; k++) {
                dp[0][k] = k;
            }

            for (int k = 1; k <= i; k++) {
                for (int l = 1; l <= j; l++) {
                    if (word1.charAt(k - 1) == word2.charAt(l - 1)) {
                        dp[k][l] = dp[k - 1][l - 1];
                    } else {
                        dp[k][l] = 1 + min(dp[k - 1][l], dp[k][l - 1], dp[k - 1][l - 1]);
                    }

                }

            }

            return dp[i][j];

        }

        private int solution(String word1, String word2, int a, int b, int dp[][]) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            if (dp[a - 1][b - 1] != -1) {
                return dp[a - 1][b - 1];
            } else if (word1.charAt(a - 1) == word2.charAt(b - 1)) {
                dp[a - 1][b - 1] = solution(word1, word2, a - 1, b - 1, dp);
            } else {
                dp[a - 1][b - 1] = 1 + min(solution(word1, word2, a, b - 1, dp), // Insert
                        solution(word1, word2, a - 1, b, dp), // Remove
                        solution(word1, word2, a - 1, b - 1, dp) // Replace
                );
            }

            return dp[a - 1][b - 1];

        }


        private int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }


    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse",
                "ros"));
    }
}
