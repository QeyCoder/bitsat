package roundzero.day58;

import roundzero.template.FastInputReader;
import roundzero.template.MiscUtils;

/**
 * Created by Gaurav on 27/02/18.
 */


public class CuttingRod {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();

        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int x = fastInputReader.readInt();
            int y = fastInputReader.readInt();
            int z = fastInputReader.readInt();

            int[] dp = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                dp[i] = -1;
            }
            stringBuilder.append(dpSolution(N, dp, x, y, z)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        if (n - x >= 0) {
            max = MiscUtils.max(max, 1 + solution(n - x, x, y, z));
        }
        if (n - y >= 0) {
            max = MiscUtils.max(max, 1 + solution(n - y, x, y, z));
        }
        if (n - z >= 0) {
            max = MiscUtils.max(max, 1 + solution(n - z, x, y, z));
        }
        return max;


    }

    private static int dpSolution(int n, int[] dp, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        if (dp[n] == -1) {
            if (n - x >= 0) {
                dp[n] = 1 + dpSolution(n - x, dp, x, y, z);
            }
            if (n - y >= 0) {
                dp[n] = MiscUtils.max(dp[n], 1 + dpSolution(n - y, dp, x, y, z));
            }
            if (n - z >= 0) {
                dp[n] = MiscUtils.max(dp[n], 1 + dpSolution(n - z, dp, x, y, z));
            }
            if (dp[n] == -1) {
                dp[n] = Integer.MIN_VALUE;
            }
        }

        return dp[n];


    }


}
