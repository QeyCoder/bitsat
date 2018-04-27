package day71;


class MinimumBstDiff {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int prev = -1;
        if (root == null) {
            return 0;
        }

        if (root.left != null)
            minDiffInBST(root.left);
        if(prev!=-1)
            min =  Math.min(min,root.val-prev);
        if (root.right != null)
            minDiffInBST(root.right);
        return min;

    }
}