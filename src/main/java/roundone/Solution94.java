package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {

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
        List<Integer> op;

        public List<Integer> inorderTraversal(TreeNode root) {

            op = new ArrayList<>();


            iterative(root);
            return op;
        }

        public void recursive(TreeNode root) {

            if (root == null) {
                return;
            }
            recursive(root.left);
            op.add(root.val);
            recursive(root.right);
        }

        private void iterative(TreeNode root) {

            Stack<TreeNode> treeNodes = new Stack<>();

            treeNodes.add(root);

            while (!treeNodes.empty()) {
                TreeNode item = treeNodes.pop();
                if (item != null) {
                    op.add(item.val);
                    treeNodes.add(item.right);
                    treeNodes.add(item.left);
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution solution
                = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(solution.inorderTraversal(root));
    }
}
