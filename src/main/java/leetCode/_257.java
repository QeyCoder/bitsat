package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _257 {


    public List<String> binaryTreePaths(TreeNode root) {

        List<String> op = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        queue.add(root);
        List<Integer> integers = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode element = queue.pop();
            if (element != null) {
                integers.add(element.val);
                if (element.right != null) queue.add(element.right);
                if (element.left != null) queue.add(element.left);
            }

            if (element.left == null && element.right == null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer integer : integers) {
                    stringBuilder.append(integer).append("->");
                }

                op.add(stringBuilder.substring(0, stringBuilder.length() - 2));
                System.out.println(op);
                integers.remove(integers.size() - 1);
            }


        }
        return op;


    }

    public void binaryTreePaths(TreeNode root, List<Integer> path, List<String> finalPath) {

        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : path) {
                stringBuilder.append(integer).append("->");
            }
            finalPath.add(stringBuilder.substring(0, stringBuilder.length() - 2));

        } else {
            binaryTreePaths(root.left, path, finalPath);
            binaryTreePaths(root.right, path, finalPath);
        }
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        _257
                obj = new _257();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);

        List<String> finalPath = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        obj.binaryTreePaths(root, path, finalPath);
        System.out.printf("s");
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
