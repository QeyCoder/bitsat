package roundone;

public class Solution27 {

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int i=0;
            for(int j=0;j< nums.length;j++){
                if(nums[j]!=val){
                    nums[i++]=nums[j];
                }
            }
            return i;
        }
    }
    public static void main(String[] args) {

        Solution solution
                 =  new Solution();
        solution.removeElement(new int[]{0,1,2,2,3,0,4,2},2);

    }
}
