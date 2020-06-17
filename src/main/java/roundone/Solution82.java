package roundone;

import java.util.List;

public class Solution82 {
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

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    static class Solution {
//0,1,2,2,3,4,5,5,6

        public ListNode deleteDuplicates(ListNode head) {
            ListNode prev = new ListNode(0);
            prev.next= head;

            ListNode tmp = head.next;
            while (tmp != null) {
                while ((tmp != null) && (head.val == tmp.val)) {
                    tmp = tmp.next;
                }
                System.out.println("");
            }
            return prev;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(5);
        four.next = five;
        three.next = four;
        two.next = three;
        one.next = two;
        solution.deleteDuplicates(one);
    }
}
