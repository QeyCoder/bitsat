package dpStorm;

import java.util.Scanner;

/**
 * @author key_coder
 * @problem https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 */
public class Solution416 {
    static class Solution {
        public boolean canPartition(int[] nums) {

            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if(sum%2!=0){
                return false;
            }
            sum /= 2;
            return solve(nums, sum);
        }

        public boolean solve(int[] nums, int sum) {


            boolean[][] dp = new boolean[nums.length + 1][sum + 1];


            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = true;

            }

            for (int i = 1; i <= sum; i++) {
                dp[0][i] = false;

            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (nums[i-1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }
            return dp[dp.length - 1][dp.length - 1];
        }

        public String toString(boolean[][] b) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    stringBuilder.append(b[i][j]);
                    stringBuilder.append("-");
                }
                stringBuilder.append("\n\n");
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());
        Solution solution = new Solution();
        solution.canPartition(new int[]{2,4});
        for (int i = 0; i < testCase; i++) {
//            solution.canPartition();
        }
    }
}