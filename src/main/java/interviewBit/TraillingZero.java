package interviewBit;

public class TraillingZero {
    public static class Solution {
        public int trailingZeroes(int A) {
            int ans=0;
            int ip=5;
            while(ip<A){
                ans+=A/ip;
                ip*=5;
            }
            return ans;

        }
    }

    public static void main(String[] args) {
        new Solution().trailingZeroes(9247);
    }

}



