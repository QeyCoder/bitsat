package roundone;

import roundone.helper.TreeNode;

public class Solution226 {

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return null;
            }
            TreeNode left = root.left;
            root.left = root.right;
            root.right=left;
            invertTree(root.left);
            invertTree(root.right);
            return root;


        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
