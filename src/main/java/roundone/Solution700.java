package roundone;

import roundone.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution700 {


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
    static class Solution {
        public int widthOfBinaryTree(TreeNode root) {


            Queue<TreeNode> queue = new LinkedList<>();
            int maxWidth = 0;
            int width=0;
            queue.add(root);
            queue.add(null);

            while(queue.size()>0){
                TreeNode element=queue.poll();

                if(element==null){
                    if(width> maxWidth){
                        maxWidth=width;
                    }
                    queue.add( null);
                }else{if(element.val!=-1){
                    if(element.left==null){
                        queue.add(new TreeNode(-1));
                    }else{ queue.add(element.left);

                    }
                    if(element.right==null){
                        queue.add(new TreeNode(-1));
                    }else{
                        queue.add(element.right);

                    }
                }
                }
                width++;
            }
            return maxWidth;

        }
    }

    public static void main(String[] args) {
        Solution solution
                 =  new Solution();
        TreeNode root =  new TreeNode(1);

        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        solution.widthOfBinaryTree(root);

    }
}



