package roundzero.flipkart;

import roundzero.template.FastInputReader;
import roundzero.template.MiscUtils;

/**
 * Created by Gaurav on 13/03/18.
 */


public class KnapSack {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int W = fastInputReader.readInt();
            int[] val = fastInputReader.readIntArray(N);
            int[] wt = fastInputReader.readIntArray(N);
            int[][] dp = new int[N + 1][W + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < W; j++) {
                    dp[i][j] = -1;
                }
            }
            stringBuilder.append(solution(val, wt, N - 1, W)).append("\n");
            stringBuilder.append(solution1(dp, val, wt, N - 1, W)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] val, int[] wt, int n, int w) {

        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n] > w) {
            return solution(val, wt, n - 1, w);
        } else {
            return MiscUtils.max(val[n] + solution(val, wt, n - 1, w - wt[n]), solution(val, wt, n - 1, w));
        }
    }

    private static int solution1(int[][] dp, int[] val, int[] wt, int n, int w) {

        if (n == 0 || w == 0) {
            dp[n][w] = 0;
            return dp[n][w];
        }
        if (wt[n] > w) {
            if (dp[n][w] != -1) {
                dp[n][w] = solution(val, wt, n - 1, w);
            }
            return dp[n][w];
        } else {
            if (dp[n][w] != -1) {
                dp[n][w] = MiscUtils.max(val[n] + solution1(dp, val, wt, n - 1, w - wt[n]), solution1(dp, val, wt, n - 1, w));
            }
            return dp[n][w];
        }
    }


}
