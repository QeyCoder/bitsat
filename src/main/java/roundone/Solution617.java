package roundone;


class Solution617 {
    class TreeNode {
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

    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = mergeNodes(t1, t2);
        return root;
    }

    private TreeNode mergeNodes(TreeNode t1, TreeNode t2) {
        TreeNode root = new TreeNode();
        if (t1 != null && t2 != null) {
            root.val = t1.val + t2.val;
            root.left = mergeNodes(t1.left, t2.left);
            root.right = mergeNodes(t1.right, t2.right);
        } else if (t1 != null && t2 == null) {
            root.val = t1.val;
            root.left = mergeNodes(t1.left, null);
            root.right = mergeNodes(t1.right, null);
        } else if (t1 == null && t2 != null) {
            root.val = t2.val;
            root.left = mergeNodes(null, t2.left);
            root.right = mergeNodes(null, t2.right);
        } else {
            return null;
        }
        return root;


    }
}