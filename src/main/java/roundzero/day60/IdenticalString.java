package roundzero.day60;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 05/03/18.
 */

//https://www.geeksforgeeks.org/minimum-cost-make-two-strings-identical/
public class IdenticalString {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int X = fastInputReader.readInt();
            int Y = fastInputReader.readInt();

            String strX = fastInputReader.readString();
            String strY = fastInputReader.readString();

            int[][] dp = new int[strX.length() + 1][strY.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = -1;
                }
            }
            stringBuilder.append(solution(dp, 0, strX, strY, X, Y, strX.length() - 1, strY.length() - 1)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[][] dp, int cost, String strX, String strY, int x, int y, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == 0) {
            dp[i][j] =  j * y;
        }
        if (j == 0) {
            dp[i][j]= i * x;
        }else if (strX.charAt(i) == strY.charAt(j)) {
            dp[i][j] = cost + dp[i - 1][j - 1] + 1;
            // do nothing no deletion required
        } else {
            dp[i][j] = cost + FastInputReader.MiscUtils.min(solution(dp, cost + x, strX, strY, x, y, i - 1, j), solution(dp, cost + y, strX, strY, x, y, i, j - 1));
            //return MiscUtils.min(solution(cost + x, strX, strY, x, y, i - 1, j), solution(cost + y, strX, strY, x, y, i, j - 1));
        }
        return dp[i][j];

    }

    private static int solutiosn(int cost, String strX, String strY, int x, int y, int i, int j) {

        if (i < 0) {
            return cost + j * y;
        }
        if (j < 0) {
            return cost + i * x;
        }

        if (strX.charAt(i) == strY.charAt(j)) {
            return solutiosn(cost, strX, strY, x, y, i - 1, j - 1);
            // do nothing no deletion required
        } else {
            return cost + FastInputReader.MiscUtils.min(solutiosn(cost + x, strX, strY, x, y, i - 1, j), solutiosn(cost + y, strX, strY, x, y, i, j - 1));
        }

    }


}
