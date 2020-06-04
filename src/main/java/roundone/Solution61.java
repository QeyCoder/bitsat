package roundone;

import day71.LinkLIstCycle;

public class Solution61 {

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
            return val + "==>" + next;
        }
    }

    static class Solution {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         * int val;
         * ListNode next;
         * ListNode() {}
         * ListNode(int val) { this.val = val; }
         * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int n = 0;
            ListNode tmp = head;
            while (tmp != null) {
                tmp = tmp.next;
                n++;
            }
            if (n == 1 || k == 0 || k == n || k % n == 0) {
                return head;
            }
            k %= n;
            k = n - k;

            tmp = head;
            ListNode prev = null;
            while (k-- > 0) {
                prev = tmp;
                tmp = tmp.next;
            }

            ListNode tmp1 = tmp;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            prev.next = null;
            tmp.next = head;
            return tmp1;


        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);


        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
//        five.next = six;
//        six.next = seven;
        solution.rotateRight(one, 8);

    }
}
