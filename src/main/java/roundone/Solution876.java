package roundone;

public class Solution876 {

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
        public ListNode middleNode(ListNode head) {

            if (head.next == null) {
                return head;
            }
            ListNode slow;
            ListNode fast;
            slow = head;
            fast = head.next;

            while (fast!=null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast==null){
                return slow;
            }
            return slow.next;


        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
