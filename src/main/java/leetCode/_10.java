package leetCode;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _10 {


    public static void main(String[] args) {

        _10 ref = new _10();
        System.out.println(ref.isMatch("aa", "a*"));
        System.out.println(ref.isMatch("baaabab", "*****ba*****ab"));
    }

    public boolean isMatch(String s, String p) {

        return solution(s, p, s.length(), p.length());

    }

    private boolean solution(String data, String pattern, int m, int n) {

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pattern.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1] || i > 1 && dp[0][i - 2];

        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (pattern.charAt(j - 1) == '*') {

                    if (j > 1 && pattern.charAt(j - 2) != data.charAt(i - 1) && pattern.charAt(j - 2) != '.')
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || j > 1 && dp[i][j - 2];

                } else if (pattern.charAt(j - 1) == '.' || data.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

            }
        }
        return dp[m][n];
    }

}
