package roundone;

import java.util.HashMap;
import java.util.Map;

public class Solution1315 {
    public static class TreeNode {
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

    public int sumEvenGrandparent(TreeNode root) {

        Map<TreeNode, TreeNode> hashMap = new HashMap<>();
        findEvenGrandParent(root, null, hashMap);
        int ans = 0;
        for (Map.Entry<TreeNode, TreeNode> treeNode : hashMap.entrySet()) {
            TreeNode key = treeNode.getValue();
            TreeNode val = treeNode.getValue();
            for (int i = 0; i < 2; i++) {
                if (key == null) {
                    break;
                }
                key = hashMap.get(key);
            }
            if (key!=null && key.val % 2 == 0) {
                ans+=val.val;
            }

        }
        return ans;
    }

    void findEvenGrandParent(TreeNode self, TreeNode root, Map<TreeNode, TreeNode> hashMap) {

        if (self != null) {
            hashMap.put(self, root);
            findEvenGrandParent(self.left, self, hashMap);
            findEvenGrandParent(self.right, self, hashMap);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        new Solution1315().sumEvenGrandparent(root);
    }
}
