package day60;

import template.FastInputReader;

/**
 * Created by Gaurav on 06/03/18.
 */


public class SubsequenceFrequency {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int A = fastInputReader.readInt();
            int B = fastInputReader.readInt();
            String aStr = fastInputReader.readString();
            String bStr = fastInputReader.readString();
            int[][] dp = new int[A + 1][B + 1];
            stringBuilder.append(solutionRecursive(dp, aStr, bStr, A, B)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(String aStr, String bStr, int a, int b) {
        if ((a == 0 && b == 0) || b == 0) {
            return 1;
        }
        if (b == 0) {
            return 0;
        }

        if (aStr.charAt(a) == bStr.charAt(b)) {
            return solution(aStr, bStr, a - 1, b) + solution(aStr, bStr, a - 1, b - 1);
        }
        return solution(aStr, bStr, a - 1, b);
    }

    private static int solutionRecursive(int[][] dp, String aStr, String bStr, int a, int b) {
        if ((a == 0 && b == 0) || b == 0) {
            dp[a][b] = 1;
            return dp[a][b];
        }
        if (a == 0) {
            dp[a][b] = 0;
            return dp[a][b];
        }

        if (aStr.charAt(a - 1) == bStr.charAt(b - 1)) {
            dp[a][b] = dp[a - 1][b] + dp[a - 1][b - 1];
            return dp[a][b];
            //return solutionRecursive(dp, aStr, bStr, a - 1, b) + solutionRecursive(dp, aStr, bStr, a - 1, b - 1);
        }
        return solutionRecursive(dp, aStr, bStr, a - 1, b);
    }


}
