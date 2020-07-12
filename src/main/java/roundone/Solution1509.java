package roundone;

import java.util.Arrays;

public class Solution1509 {

    class Solution {
        public int minDifference(int[] nums) {

            Arrays.sort(nums);
            int result = Integer.MAX_VALUE;
            if (nums.length < 5) {
                return 0;
            }

            for (int i = 0; i < 4; i++) {


                result = Math.min(result, nums[nums.length - 4 + i] - nums[i]);

            }
            return result;
        }
    }
}



