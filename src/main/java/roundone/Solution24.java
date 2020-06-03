package roundone;

public class Solution24 {

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

    static class Solution {
        public ListNode swapPairs(ListNode head) {

            return swap(head);
        }

        private ListNode swap(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp = head.next;
            head.next = swap(head.next.next);
            temp.next = head;
            head = temp;

            return head;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
