package day57;

import template.FastInputReader;
import template.MiscUtils;

/**
 * Created by Gaurav on 25/02/18.
 */


public class MaxCostSumPath {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int[][] data = fastInputReader.readTable(N, N);
            //stringBuilder.append(solution(data, 0, 0)).append("\n");
            stringBuilder.append(dpSolution(data, N - 1, N - 1)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[][] data, int i, int k) {
        if (i > data.length - 1 || k > data.length - 1) {
            return Integer.MAX_VALUE;
        } else if (i == data.length - 1 && k == data.length - 1) {
            return data[i][k];
        } else {
            return data[i][k] + MiscUtils.min(MiscUtils.min(solution(data, i, k + 1), solution(data, i + 1, k)), solution(data, i + 1, k + 1));

        }

    }


    private static int dpSolution(int[][] data, int i, int j) {


        int[][] dp = new int[i + 1][j + 1];
        dp[0][0] = data[0][0];

        for (int k = 1; k <= i; k++) {
            dp[0][k] = dp[0][k - 1] + data[0][k];
        }
        for (int k = 1; k <= j; k++) {
            dp[k][0] = dp[k - 1][0] + data[k][0];
        }


        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                dp[k][l] = data[k][l] + MiscUtils.min(MiscUtils.min(dp[k][l - 1], dp[k - 1][l]), dp[k - 1][l - 1]);
            }

        }
        return dp[i][j];


    }


}
