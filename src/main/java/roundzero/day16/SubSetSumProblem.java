package roundzero.day16;

/**
 * Created by Gaurav on 14/11/17.
 */
public class SubSetSumProblem {


    public static void main(String[] args) {
        InputReader inputReader
                = new InputReader(System.in);
        int sizeOfSet = inputReader.nextInt();

        int[] inputSet = new int[sizeOfSet];
        for (int i = 0; i < sizeOfSet; i++) {
            inputSet[i] = inputReader.nextInt();
        }
        int sumTobeFind = inputReader.nextInt();

        System.out.println(solution(inputSet, sumTobeFind));
    }

    private static boolean solution(int[] inputSet, int sumTobeFind) {
        boolean[][] dp = new boolean[inputSet.length][sumTobeFind + 1];

        for (int i = 0; i < inputSet.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < inputSet.length; i++) {
            for (int j = 1; j <= sumTobeFind; j++) {

                if (i == 0) {
                    dp[i][j] = (j == inputSet[i]);
                } else {
                    if (inputSet[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    }else{
                        if (dp[i - 1][j] == true) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i - 1][j-inputSet[i]];
                        }
                    }

                }
            }

        }
        return dp[inputSet.length - 1][sumTobeFind];
    }

}
