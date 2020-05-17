package roundzero.day59;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 28/02/18.
 */


public class ParitionProblem {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int[] data = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static boolean solution(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[data.length + 1][sum];
        return findMemoSet(data, dp, sum, data.length - 1);
        //return findSet(data, sum, data.length - 1);
    }

    private static boolean findMemoSet(int[] data, boolean[][] dp, int sum, int index) {


        if (sum == 0) {
            dp[index][sum - data[index]] = true;
            return true;
        }
        if (index < 0 && sum != 0) {
            return false;
        }
        if (data[index] > sum) {
            dp[index][sum] = findSet(data, sum, index - 1);
            return dp[index - 1][sum];
        }

        dp[index][sum] = findSet(data, sum - data[index], index - 1) || findSet(data, sum, index - 1);
        return dp[index][sum];

    }

    private static boolean findSet(int[] data, int sum, int index) {

        if (sum == 0) {
            return true;
        }
        if (index < 0 && sum != 0) {
            return false;
        }
        if (data[index] > sum) {
            return findSet(data, sum, index - 1);
        }

        return findSet(data, sum - data[index], index - 1) || findSet(data, sum, index - 1);

    }


}
