package roundone;

import roundone.helper.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution100 {


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
        public boolean isSameTree(TreeNode p, TreeNode q) {

            if(p==null && q ==null){
                return true;
            }
            if(p==null && q!=null || q==null && p!=null){
                return false;
            }
            if(p.val ==q.val){

                boolean left =  isSameTree(p.left,q.left) ;
                boolean right=isSameTree(p.right,q.right);
                return left && right;
            }
            return false;

        }
    }
}



