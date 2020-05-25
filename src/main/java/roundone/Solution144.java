package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        List<Integer> ans;
        public List<Integer> preorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            iterative(root);
            return ans;
        }

        private void recursive(TreeNode root){
            if(root==null){
                return;
            }
            ans.add(root.val);
            recursive(root.left);
            recursive(root.right);

        }
        private void iterative(TreeNode root){

            Stack<TreeNode> treeNodes =  new Stack<>();

            treeNodes.add(root);

            while (!treeNodes.empty()){
                TreeNode item = treeNodes.pop();
                if(item!=null){
                    ans.add(item.val);
                    treeNodes.add(item.right);
                    treeNodes.add(item.left);

                }
            }




        }
    }
}
