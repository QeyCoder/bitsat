package roundone;

public class Solution121 {

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int profit = 0;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }else if(prices[i]-min> profit){
                    profit =prices[i]-min;
                }
            }
            return profit ;

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        sol.maxProfit(new int[]{7, 6, 4, 3, 1});
        sol.maxProfit(new int[]{7, 1, 5, 1, 16, 74});
        sol.maxProfit(new int[]{});
        sol.maxProfit(new int[]{1, 4, 2});
        sol.maxProfit(new int[]{3, 2, 6, 5, 0, 3});
    }
}
