package day54;

import template.FastInputReader;
import template.MiscUtils;

/**
 * Created by Gaurav on 22/02/18.
 */
public class LongestCommanSUbSequence {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();

        int T = fastInputReader.readInt();

        for (int i = 0; i < T; i++) {
            fastInputReader.readInt();
            fastInputReader.readInt();
            String A = fastInputReader.readString();

            String B = fastInputReader.readString();
            System.out.println(solution(A, B, A.length(), B.length()));
        }

    }

    private static int solution(String a, String b, int i, int j) {
        int[][] dp = new int[i + 1][j + 1];
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l <=j; l++) {
                if (k == 0 || l == 0) {
                    dp[k][l] = 0;
                } else if (a.charAt(k - 1) == b.charAt(l - 1)) {
                    dp[k][l] = 1 + dp[k - 1][l - 1];
                } else {
                    dp[k][l] = MiscUtils.max(dp[k - 1][l], dp[k][l - 1]);
                }
            }
        }


        return dp[i][j];

    }
}
