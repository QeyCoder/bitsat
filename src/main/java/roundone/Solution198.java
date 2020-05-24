package roundone;

import java.util.Arrays;

public class Solution198 {

    static class Solution {
        int[] dp;

        public int rob(int[] nums) {
            dp = new int[nums.length + 1];
            //Arrays.fill(dp, -1);
            return solve(nums);
        }

        //RECUSRIVE
        int solveRecu(int[] num, int start, int total) {
            if (start >= num.length) {
                return total;
            }
            return Math.max(solveRecu(num, start + 2, total + num[start]), solveRecu(num, start + 1, total));
        }


        //MEMO
        int solveMemo(int[] num, int start) {
            if (start < 0) {
                return 0;
            }
            if (dp[start] >= 0) {
                return dp[start];
            }
            int result = Math.max(solveMemo(num, start - 2) + num[start], solveMemo(num, start - 1));
            dp[start] = result;
            return dp[start];
        }


        //iterative + memo
        int solve1(int[] num) {
            if (num.length == 0) {
                return 0;
            }
            dp[0] = 0;
            dp[1] = num[0];

            for (int i = 1; i < num.length; i++) {
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + num[i]);
            }

            return dp[num.length];

        }


        //iterative with less space

        int solve(int[] num) {
            if (num.length == 0) {
                return 0;
            }
            int first = 0;
            int second = num[0];
            for (int i = 1; i < num.length; i++) {
                int prev = second;
                second =  Math.max(second, first + num[i]);
                first=prev;
            }

            return second;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }
}
