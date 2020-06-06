package dpStorm;

import java.util.Scanner;

/**
 * @author  key_coder
 * @problem https://www.geeksforgeeks.org/friends-pairing-problem/
 */
public class FriendPairing {

    static class Solution {
        static int solution(int input) {
            if (input <= 2) {
                return input;
            }

            double[] dp = new double[input + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i < dp.length; i++) {
                dp[i] = (dp[i - 1] + ((i - 1) * dp[i - 2])) % 1000000007;
            }
            return (int) dp[input];
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCase; i++) {
            System.out.println(solution.solution(Integer.parseInt(scanner.nextLine())));
        }
    }
}
