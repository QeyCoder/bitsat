package roundone;

import java.util.Scanner;

public class Solution617A {


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(solve(Integer.parseInt(scanner.nextLine())));
    }

    private static int solve(int s) {
        if (s <= 5) {
            return 1;
        }
        int dp[] = new int[s + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        dp[5] = 1;

        for (int i = 6; i < dp.length; i++) {
            dp[i] = Math.min(Math.min(Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 3]), dp[i - 4]), dp[i - 5]) + 1;
        }
        return dp[dp.length - 1];
    }
}
