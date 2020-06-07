package roundone;

public class Solution1470 {

    static class Solution {
        public int[] shuffle(int[] nums, int n) {

            int[] ans = new int[2 * n];
            int i = 0;
            int j = n ;
            int k = 0;
            while (k < 2 * n - 1) {
                ans[k] = nums[i];
                ans[k+1] = nums[j];
                i++;
                j++;
                k += 2;
            }
            return ans;


        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.shuffle(new int[]{2,5,1,3,4,7},3);
    }
}
