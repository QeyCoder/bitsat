package roundone;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

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
        public List<String> binaryTreePaths(TreeNode root) {

            StringBuilder strBuilder = new StringBuilder();
            solution(root, strBuilder);
            return ans;
        }

        List<String> ans = new ArrayList<String>();

        public void solution(TreeNode root, StringBuilder strngBuilder) {
            if (root == null) {
                return;
            }
            int tmp = strngBuilder.length();
            if (root.left == null && root.right == null) {
                strngBuilder.append(root.val);
                ans.add(strngBuilder.toString());
                strngBuilder.delete(tmp, strngBuilder.length());
            }
            strngBuilder.append(root.val);
            strngBuilder.append("->");
            solution(root.left,strngBuilder);
            solution(root.right,strngBuilder);
            strngBuilder.delete(tmp, strngBuilder.length());
            return;
        }
    }

    public static void main(String[] args) {
        Solution solution
                = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        solution.binaryTreePaths(root);
    }
}
