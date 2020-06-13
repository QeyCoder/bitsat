package roundone;

public class Solution1475 {

    static class Solution {
        public int[] finalPrices(int[] prices) {

            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length ; j++) {
                    if (prices[i] > prices[j]) {
                        prices[i] -= prices[j];
                        break;
                    }
                }
            }
            return prices;


        }
    }
//[1,3,2,1,7,1,0,7,10,1]
//[1,3,2,1,7,0,0,6,9,1]
    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.finalPrices(new int[]{8, 7, 4, 2, 8, 1, 7, 7, 10, 1});
    }
}
