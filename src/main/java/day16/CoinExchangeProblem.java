package day16;

/**
 * Created by Gaurav on 14/11/17.
 */
//http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
public class CoinExchangeProblem {

    public static void main(String[] args) {


        InputReader inputReader
                = new InputReader(System.in);
        int setSize = inputReader.nextInt();
        int sum = inputReader.nextInt();
        int[] set = new int[setSize];
        for (int i = 0; i < setSize; i++) {
            set[i] = inputReader.nextInt();
        }
        System.out.println(solution(set, sum));
    }

    private static int solution(int[] set, int sum) {


        int row = set.length + 1;
        int col = sum + 1;
        int[][] dp = new int[row][col];


        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }




        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //way when we include incoming element + when element is not included.
                if (set[i-1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - set[i-1]];
                }

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j]+ " ");

            }
            System.out.println();
        }

        return dp[row-1][col-1];

    }

}
