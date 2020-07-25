package roundone;

import roundone.helper.TreeNode;

import java.util.*;

public class Solution103 {


    class Solution {
        Queue<TreeNode> ip = new LinkedList<>();
        boolean left = true;

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


            List<List<Integer>> ans = new ArrayList<>();


            Stack<TreeNode> level1 = new Stack<>();
            Stack<TreeNode> level2 = new Stack<>();
            List<Integer> ip = new ArrayList<>();

            level1.add(root);
            boolean left = true;
            while (level1 != null) {
                TreeNode item = level1.pop();


                if (left) {
                    if (item.left != null) {
                        level2.add(item.left);
                    }
                    if (item.right != null) {
                        level2.add(item.right);
                    }
                } else {
                    if (item.right != null) {
                        level2.add(item.right);
                    }
                    if (item.left != null) {
                        level2.add(item.left);
                    }
                }
                ip.add(item.val);
                if (level1.empty()) {
                    Stack<TreeNode> tmp = level1;
                    level1 = level2;
                    level2 = tmp;
                    ans.add(ip);
                    ip = new ArrayList<>();

                }


            }

return ans;
        }
    }
}



