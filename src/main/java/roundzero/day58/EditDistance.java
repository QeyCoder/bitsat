package roundzero.day58;

import roundzero.template.FastInputReader;
import roundzero.template.MiscUtils;

/**
 * Created by Gaurav on 26/02/18.
 */


public class EditDistance {


    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        StringBuilder stringBuilder = new StringBuilder();

        while (T-- > 0) {
            int alen = fastInputReader.readInt();
            int blen = fastInputReader.readInt();
            String A = fastInputReader.readString();
            String B = fastInputReader.readString();

            stringBuilder.append(dpSolution(A, B, A.length(), B.length())).append("\n");
        }

        System.out.println(stringBuilder);


    }


    private static int dpSolution(String a, String b, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {


                if (i == 0) {
                    dp[i][j] = j;
                }
               else if (j == 0) {
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = 1 + MiscUtils.min(MiscUtils.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];

    }

    private static int solution(String a, String b, int i, int j) {

        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return solution(a, b, i - 1, j - 1);
        }

        return 1 + MiscUtils.min(MiscUtils.min(solution(a, b, i - 1, j), solution(a, b, i, j - 1)), solution(a, b, i - 1, j - 1));


    }


}
