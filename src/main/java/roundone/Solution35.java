package roundone;

public class Solution35 {
    static class Solution {
        public int searchInsert(int[] nums, int target) {

//         int low=0;
//         int high= nums.length-1;

//         while(low< high){
//             int mid = low+ (high-low)/2;
//             if(nums[mid]== target){
//                 return mid;
//             }
//         }
            if (target <= nums[0]) {
                return 0;
            }
            if(target> nums[nums.length-1]){
                return nums.length;
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == target) {
                    return i - 1;
                } else if (target >= nums[i - 1] && target <= nums[i]) {
                    if(target==nums[i-1]){
                        return i-1;
                    }
                    return i;
                }
            }
            return nums.length;

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3}, 3));
    }
}
