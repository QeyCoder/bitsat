package roundone;

public class Solution1367 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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

    static class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if(head==null){
                return true;
            }
            if(root==null){
                return false;
            }

            return dfs(head, root)||isSubPath(head, root.left)||isSubPath(head, root.right);

        }

        private boolean dfs(ListNode head, TreeNode root){
            if(head==null){
                return true;
            }
            if(root==null){
                return false;
            }
            if(root.val==head.val){
                return dfs(head.next, root.left) || dfs(head.next, root.right);
            }
            return false;


        }


    }
    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
