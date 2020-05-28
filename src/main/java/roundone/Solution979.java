package roundone;

public class Solution979 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int ans=0;
        public int distributeCoins(TreeNode root) {
            noMove(root);
            return ans;
        }

        private int noMove(TreeNode root){
            if(root==null){
                return 0;
            }else{

                int leftAns = noMove(root.left);
                int rightAns = noMove(root.right);
                ans+=  Math.abs(leftAns)+Math.abs(rightAns);
                return   root.val+leftAns+rightAns-1;
            }
        }
    }
}
