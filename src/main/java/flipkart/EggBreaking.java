package flipkart;

import template.FastInputReader;

/**
 * Created by Gaurav on 27/03/18.
 */


public class EggBreaking {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int EGG = fastInputReader.readInt();
            int FLOOR = fastInputReader.readInt();

            System.out.println(recurSiveSolution(EGG, FLOOR));
            System.out.println(solution(EGG, FLOOR));

        }
    }

    private static int solution(int EGG, int FLOOR) {
        int dp[][] = new int[EGG + 1][FLOOR + 1];

        for (int i = 0; i <= FLOOR; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= EGG; i++) {
            for (int j = 1; j <= FLOOR; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int max = 1 + FastInputReader.MiscUtils.max(dp[i - 1][k - 1], dp[i][j - k]);
                    if (max < dp[i][j]) {

                        dp[i][j] = max;
                    }
                }
            }
        }
        return dp[EGG][FLOOR];
    }


    private static int recurSiveSolution(int egg, int floor) {
        if (floor == 0 || floor == 1 || egg == 1) {
            return floor;
        }


        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floor; i++) {

            int eggBreak = recurSiveSolution(egg - 1, i - 1);
            int noBreak = recurSiveSolution(egg, floor - i);
            int ans = FastInputReader.MiscUtils.max(eggBreak, noBreak) + 1;

            if (ans < min) {

                min = ans;
            }

        }
        return min;

    }


}



