package roundone;

import java.util.Arrays;

public class Solution1464 {
    class Solution {
        public int maxProduct(int[] nums) {
            if(nums.length<=1){
                return 0;
            }
            Arrays.sort(nums);
            return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);

        }
    }
}
