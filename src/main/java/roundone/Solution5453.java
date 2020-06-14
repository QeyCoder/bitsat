package roundone;

public class Solution5453 {

    static class Solution {
        public int[] runningSum(int[] nums) {

            for(int i=1; i< nums.length;i++){
                nums[i]+=nums[i-1];
            }
            return nums;

        }
    }
    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
