package roundone;

public class Solution1493 {
    static class Solution {
        public int longestSubarray(int[] nums) {

            int[] prefixSum = new int[nums.length];

            for (int i = 0; i < prefixSum.length; i++) {
                if (nums[i] == 1) {
                    if (i == 0) {
                        prefixSum[i] = 1;
                    } else {
                        prefixSum[i] = prefixSum[i - 1] + 1;
                    }
                }
            }

            int[] postFix = new int[nums.length];
            for (int i = postFix.length - 1; i >= 0; i--) {
                if (nums[i] == 1) {
                    if (i == postFix.length-1) {
                        postFix[i] = 1;
                    } else {
                        postFix[i] = postFix[i + 1] + 1;
                    }
                }
            }
            int max = 0;
            for (int i = prefixSum.length - 1; i > 1; i--) {
                max = Math.max(postFix[i] + prefixSum[i - 2], max);
            }
            return max;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
}
