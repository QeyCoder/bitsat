package roundone;

public class Solution300 {

    class Solution {
        //N^2
        public int lengthOfLIS(int[] nums) {
            if(nums.length==0){
                return 0;
            }


            int[] dp= new int[nums.length];
            dp[0]=1;

            for(int i=1; i< nums.length;i++){
                dp[i]=1;
                for(int j=i-1;j>=0;j--){
                    if(nums[j]>=nums[i]){
                        //DO nothing
                        continue;
                    }
                    int ans = dp[j] +1;
                    if(ans> dp[i]){
                        dp[i]= ans;
                    }
                }
            }
            int max = 0;
            for(int i=0; i< dp.length;i++){
                if(dp[i]>max){
                    max=dp[i];
                }
            }
            return max;
        }
    }
}
