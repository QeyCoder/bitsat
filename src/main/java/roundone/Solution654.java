package roundone;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution654 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {

            return solve(nums, 0, nums.length - 1);
        }

        private TreeNode solve(int[] nums, int start, int end) {

            if (start >= 0 && start <= end && end < nums.length) {
                int index = findMax(nums, start, end);
                TreeNode root = new TreeNode(nums[index]);
                root.left = solve(nums, start, index - 1);
                root.right = solve(nums, index + 1, end);
                return root;

            }
            return null;
        }

        private int findMax(int[] nums, int start, int end) {
            int max = start;
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
