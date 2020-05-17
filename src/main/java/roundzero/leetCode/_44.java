package leetCode;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _44 {


        class Solution {
            public boolean isMatch(String s, String p) {
                return solution(s, p, s.length(), p.length());

            }

            private boolean solution(String data, String pattern, int m, int n) {

                boolean[][] dp = new boolean[m + 1][n + 1];
                dp[0][0] = true;
                for (int i = 1; i <= n; i++) {
                    if (pattern.charAt(i - 1) == '*')
                        dp[0][i] = dp[0][i - 1];

                }
                for (int i = 1; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {

                        if (pattern.charAt(j - 1) == '*') {

                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] ;

                        } else if (pattern.charAt(j - 1) == '?' || data.charAt(i - 1) == pattern.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }

                    }
                }
                return dp[m][n];
            }
        }
}
