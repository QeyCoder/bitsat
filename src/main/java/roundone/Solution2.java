package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {


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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


            int carry = 0;

            ListNode head = new ListNode(Integer.MIN_VALUE);
            ListNode tmp = head;
            while (l1 != null && l2 != null) {


                int op = l1.val + l2.val + carry;
                carry = op / 10;
                op %= 10;
                ListNode t = new ListNode(op);


                tmp.next = t;

                tmp = tmp.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                int op = l1.val + carry;
                carry = op / 10;
                op %= 10;
                ListNode t = new ListNode(op);


                tmp.next = t;

                tmp = tmp.next;
                l1 = l1.next;


            }

            while (l2 != null) {
                int op = l2.val + carry;
                carry = op / 10;
                op %= 10;
                ListNode t = new ListNode(op);


                tmp.next = t;

                tmp = tmp.next;
                l2 = l2.next;

            }
            if(carry!=0){

                ListNode d = new ListNode(1);
                d.next =  head.next;
                return d;
            }
            return head.next;


        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        new Solution().addTwoNumbers(l1, l2);
    }
}



