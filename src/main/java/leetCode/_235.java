package leetCode;

/**
 * Created by Gaurav on 30/04/18.
 */

public class _235 {


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


           if(root==null){
               return null;
           }
            if (p.val < root.val && q.val > root.val) {
                return root;
            } else if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }


        }
    }

    public static void main(String[] args) {

    }


}
