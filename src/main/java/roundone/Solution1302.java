package roundone;

import java.util.*;
import java.util.stream.IntStream;

public class Solution1302 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        solution.deepestLeavesSum(root);

    }

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

    static class Solution {

        Map<Integer, List<Integer>> map = new HashMap<>();

        public int deepestLeavesSum(TreeNode root) {
            findLeaveSum(root, 0);
            Integer max = Collections.max(map.keySet());
            if (max == null) {
                return 0;
            }
            return map.get(max).stream().mapToInt(Integer::intValue).sum();
        }

        private void findLeaveSum(TreeNode root, int height) {
            if (root == null) {
                return;
            }
            List<Integer> val = map.get(height);
            if (val == null) {
                val = new ArrayList<>();
            }
            val.add(root.val);
            map.put(height, val);
            findLeaveSum(root.left, height + 1);
            findLeaveSum(root.left, height + 1);
        }

    }
}
