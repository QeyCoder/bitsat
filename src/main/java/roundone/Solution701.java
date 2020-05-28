package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static roundone.MainClass.booleanToString;
import static roundone.MainClass.stringToTreeNode;

public class Solution701 {
    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null){
                root= new TreeNode(val);
                return root;
            }
            if (val > root.val) {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    return root;
                }else {
                    insertIntoBST(root.right, val);
                }
            } else {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    return root;
                }else{
                    return insertIntoBST(root.left, val);
                }
            }
            return root;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            TreeNode ret = new Solution().insertIntoBST(root,5);


            System.out.print(ret);
        }
    }
}
