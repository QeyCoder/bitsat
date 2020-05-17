package roundzero;

/**
 * Created by Gaurav on 17/04/18.
 */


public class BeautifulString {


    public static void main(String[] args) {

        // System.out.println(solution(1));
        System.out.println(solution(2));
        // System.out.println(solution(3));
    }

    private static int solution(int n) {
        int[][] dp = new int[n][5];

        for (int i = 0; i < 5; i++) {
            dp[0][i] = 5 - i;
        }


        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] - j;

            }

        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dp[n - 1][i];
        }
        return sum;

    }


}
