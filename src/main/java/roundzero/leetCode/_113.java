package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _113 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> finalPath = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        binaryTreePaths(root, path, finalPath, sum);
        return finalPath;
    }

    public void binaryTreePaths(TreeNode root, List<Integer> path, List<List<Integer>> finalPath, int sum) {

        if (root == null)
            return;
        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {


            if (0 == sum)
                finalPath.add(new ArrayList<Integer>(path));

        } else {
            binaryTreePaths(root.left, path, finalPath, sum);
            binaryTreePaths(root.right, path, finalPath, sum);
        }
        path.remove(path.size() - 1);

        }

    public static void main(String[] args) {
        _113
                obj = new _113();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);

        List<List<Integer>> path = obj.pathSum(root, 8);
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
