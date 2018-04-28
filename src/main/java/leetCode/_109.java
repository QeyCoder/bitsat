package leetCode;

/**
 * Created by Gaurav on 29/04/18.
 */


public class _109 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }

            return toBst(head, null);

        }

        TreeNode toBst(ListNode head, ListNode tail) {


            ListNode slow = head;
            ListNode fast = head;

            if (head == tail) return null;


            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }


            TreeNode root = new TreeNode(slow.val);

            root.left = toBst(head, slow);
            root.right = toBst(slow.next, tail);
            return root;


        }


    }

    public static void main(String[] args) {
        Solution solution
                = new Solution();

        ListNode a = new ListNode(-10);
        ListNode b = new ListNode(-3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        solution.sortedListToBST(a);
    }

}
