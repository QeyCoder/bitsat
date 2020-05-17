package roundone;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
public class Solution1161 {
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


    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int maxLevel = level;
        int maxSum = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {


            int childCount = queue.size();
            if (childCount == 0) {
                break;
            }
            int currentSum = 0;
            while (childCount > 0) {
                TreeNode node = queue.remove();
                currentSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                childCount--;

            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = level;
            }
            level++;

        }

        return maxLevel;


    }
}
