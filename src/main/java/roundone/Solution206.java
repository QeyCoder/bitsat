package roundone;

public class Solution206 {
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

    class Solution {
        public ListNode reverseList(ListNode head) {

            // return iterative(head);
            return recursive(head);


        }


        private ListNode iterative(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }

        private ListNode recursive(ListNode head) {

            if (head == null) {
                return head;
            }
            if (head.next == null) {
                return head;

            }
            ListNode current = recursive(head.next);
            head.next.next = head;
            head.next = null;
            return current;

        }
    }
}
