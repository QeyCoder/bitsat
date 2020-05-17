package roundzero.day46;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 08/02/18.
 */
public class CommanChild {
    public static void main(String[] args) {
        FastInputReader fastInputReader =  new FastInputReader();
        String str1 = fastInputReader.readString();
        String str2 = fastInputReader.readString();


        System.out.println(solution(str1, str2, str1.length(), str2.length() ));
    }

    private static int solution(String str1, String str2, int len1, int len2) {
        int[][] dp = new int[len1 + 1][len2 + 1];


        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
