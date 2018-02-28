package day58;

import template.FastInputReader;

/**
 * Created by Gaurav on 27/02/18.
 */

//sum equal to a number
public class SumSubSetProblem {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int sum = fastInputReader.readInt();
            int[] data = fastInputReader.readIntArray(N);
            boolean[][] dp = new boolean[data.length + 1][sum + 1];
            stringBuilder.append(solution1(data, dp, sum, N-1)).append("\n");
            //stringBuilder.append(dpSolution(data, sum)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static boolean solution(int[] data, int sum, int index) {

        if (sum == 0) {
            return true;
        }
        if (index >= data.length - 1 && sum != 0) {
            return false;
        }
        if (data[index] > sum) {
            return solution(data, sum, index + 1);
        }

        return
                solution(data, sum - data[index], index + 1) || solution(data, sum, index + 1);

    }


    private static boolean solution1(int[] data, boolean[][] dp, int sum, int index) {

        System.out.print("Index = " + index  + " sum = " + sum + "\n");

        if (sum == 0) {
            return true;
        }
        if(index < 0){
            return false;
        }
        if(sum < 0){
            return false;
        }
        if(index == 0 && data[0] == sum){
            return true;
        }
        if(index == 0 && data[0] != sum){
            return false;
        }

        if(sum - data[index] > 0 && dp[index-1][sum - data[index]]){
            dp[index][sum] = true;
            return true;
        }
        if (index < 0 && sum != 0) {
            return false;
        }
        if (data[index] > sum) {
            dp[index][sum] = solution1(data, dp, sum, index - 1);
        }


        dp[index][sum] = solution1(data, dp, sum - data[index], index -1) || solution1(data, dp, sum, index -1);
        return dp[index][sum];

    }


   /* static boolean dpSolution(int[] data, int sum) {

        boolean[][] dp = new boolean[data.length + 1][sum + 1];


        for (int i = 0; i < data.length; i++) {
            dp[0][i] = true;
        }
        for (int i = 0; i < sum; i++) {
            if (data[0] == i) {
                dp[i][0] = true;
            } else {
                dp[i][0] = false;
            }
        }


        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (j < data[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - data[i]];
                }

            }
        }
        return dp[data.length][sum];
    }

*/
}
