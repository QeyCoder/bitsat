package roundone;

import java.util.ArrayList;
import java.util.List;

public class Solution145 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            recursive(root);
            return ans;
        }

        List<Integer> ans;

        private void recursive(TreeNode root){
            if(root==null){
                return;
            }

            recursive(root.left);
            recursive(root.right);
            ans.add(root.val);
        }
    }
}
