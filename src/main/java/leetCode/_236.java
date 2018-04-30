package leetCode;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _236 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }

            TreeNode leftcA = lowestCommonAncestor(root.left, p, q);
            TreeNode rightcA = lowestCommonAncestor(root.right, p, q);


            return leftcA == null ? rightcA : rightcA == null ? leftcA : root;

        }
    }

    public static void main(String[] args) {

    }


}
