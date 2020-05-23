package roundone;

public class Solution206 {
    public static class ListNode {
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

    static class Solution {
        public ListNode reverseList(ListNode head) {

            // return iterative(head);
//            return recursive(head);

            return reverseListInt(head, null);
        }

        private ListNode reverseListInt(ListNode head, ListNode newHead) {
            if (head == null)
                return newHead;
            ListNode next = head.next;
            head.next = newHead;
            return reverseListInt(next, head);
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

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        new Solution().reverseList(root);
    }
}
