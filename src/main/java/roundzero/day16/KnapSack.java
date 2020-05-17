package roundzero.day16;

/**
 * Created by Gaurav on 15/11/17.
 */
public class KnapSack {

    //0-1 knapsack solution

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);

        int totalWeight = inputReader.nextInt();
        int setSize = inputReader.nextInt();
        int[] weight = new int[setSize];
        int[] value = new int[setSize];
        for (int i = 0; i < setSize; i++) {
            value[i] = inputReader.nextInt();
            weight[i] = inputReader.nextInt();
        }
        System.out.println(solution(weight, value, totalWeight));
    }

    private static int solution(int[] weight, int[] value, int totalWeight) {

        int row = weight.length;
        int col = totalWeight + 1;
        int[][] dp = new int[row][col];


        for (int i = 0; i < row; i++) {
            dp[i][0] = 0;

        }

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (i == 0) {
                    if (weight[i] <= totalWeight) {
                        dp[i][j] = value[i];
                    }
                } else {
                    if (j < weight[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                    }
                }

            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " | ");
                stringBuilder.append("--*-");

            }
            System.out.println("\n" + stringBuilder);
            stringBuilder = new StringBuilder();
        }
        return dp[row-1][col-1];
        //return 1;
    }
}
