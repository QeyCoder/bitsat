package roundone;

public class Solution213 {
    class Solution {
        public int rob(int[] nums) {
            if(nums.length==1){
                return nums[0];
            }
            return Math.max(solution(nums,0,nums.length-2),solution(nums,1, nums.length-1));
        }


        private int solution(int[] nums,int start, int limit){
            if (nums.length == 0) {
                return 0;
            }
            int prev=0;
            int current=nums[start];
            for(int i=start+1; i<= limit; i++){
                int tmp = current;
                current = Math.max(prev+nums[i] ,current);
                prev= tmp;

            }
            return current;

        }

    }
}
