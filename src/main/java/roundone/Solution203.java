package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution203 {

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
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;

            }
            ListNode tmp = head;
            ListNode prev = null;

            while (tmp != null) {
                if (tmp.val == val) {
                    prev.next = tmp.next;
                    tmp = prev;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            return head;

        }
    }
}



