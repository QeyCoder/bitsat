package roundone;

public class Soution518 {

    static class Solution {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length + 1][amount + 1];

            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < dp[0].length; i++) {
                dp[0][i] = 0;
            }


            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if(j< coins[i-1]){
                        dp[i][j]=  dp[i-1][j];
                    }else{
                        dp[i][j]= dp[i-1][j]+ dp[i][j-coins[i-1]];
                    }
                }
            }
            return dp[coins.length][amount];
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }
}
