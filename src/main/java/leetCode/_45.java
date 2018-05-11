package leetCode;

/**
 * Created by himan on 11-05-2018.
 */
public class _45 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }

    static class Solution {
        public int jump(int[] nums) {
            return solution(nums, 0, nums.length - 1);
        }
//recursive
        private int solution(int[] nums, int start, int end) {

            if (start == end) {
                return 0;
            }

            if (nums[start] == 0) return Integer.MAX_VALUE;
            int cost = Integer.MAX_VALUE;
            for (int j = start + 1; j <= end && j <= start + nums[start]; j++) {
                int jump = solution(nums, j, end);
                if (jump != Integer.MAX_VALUE && jump + 1 < cost) {
                    cost = jump + 1;
                }

            }
            return cost;

        }
        private int solution(int[] nums,int[] dp, int start, int end) {

            if (start == end) {
                return 0;
            }

            if (nums[start] == 0 ) return Integer.MAX_VALUE;
            int cost = Integer.MAX_VALUE;
            for (int j = start + 1; j <= end && j <= start + nums[start]; j++) {
                int jump = solution(nums, j, end);
                if (jump != Integer.MAX_VALUE && jump + 1 < cost) {
                    cost = jump + 1;
                }

            }
            return cost;

        }
        
    }
}
