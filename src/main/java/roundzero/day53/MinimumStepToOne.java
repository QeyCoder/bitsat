package day53;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 18/02/18.
 */
public class MinimumStepToOne {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();

        int[] dp = new int[N+1];
        for (int i = 0; i <=N; i++) {
            dp[i] = -1;
        }
        System.out.println(minimumStep(N, dp));

    }

    private static int minimumStep(int n, int[] dp) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int r = 1 + minimumStep(n - 1, dp);
        if (n % 2 == 0) {
            r = min(r, 1 + minimumStep(n / 2, dp));
        } else if (n % 3 == 0) {
            r = min(r, 1 + minimumStep(n / 3, dp));
        }
        dp[n] = r;
        return r;

    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

}
