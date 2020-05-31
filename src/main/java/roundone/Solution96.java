package roundone;

import roundone.helper.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static roundone.MainClass.booleanToString;
import static roundone.MainClass.stringToTreeNode;

public class Solution96 {


    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, null, null);
        }


        private boolean isValid(TreeNode root, Integer lower, Integer upper) {
            if (root == null) {
                return true;
            }


            if (lower != null && root.val <= lower) {
                return false;
            }

            if (upper != null && root.val >= upper) {
                return false;
            }
            if (!isValid(root.right, root.val, upper)) return false;
            if (!isValid(root.left, lower, root.val)) return false;
            return true;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                TreeNode root = stringToTreeNode(line);

                boolean ret = new Solution().isValidBST(root);

                String out = booleanToString(ret);

                System.out.print(out);
            }
        }
    }
}