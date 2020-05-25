package roundone;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public class TreeNode {
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

    class Solution {
        List<Integer> ans;

        public List<Integer> preorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            recursive(root);
            return ans;
        }

        private void recursive(TreeNode root) {
            if (root == null) {
                return;
            }
            ans.add(root.val);
            recursive(root.left);
            recursive(root.right);

        }
    }
}
