package roundone;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution24 {

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
        public ListNode mergeKLists(ListNode[] lists) {

            PriorityQueue<Integer> listNodes = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            for (int i = 0; i < lists.length; i++) {
                ListNode lnked = lists[i];
                while (lnked != null) {
                    listNodes.add(lnked.val);
                    lnked = lnked.next;
                }
            }
            ListNode head = new ListNode(listNodes.poll());
            ListNode element = head;
            while (!listNodes.isEmpty()) {
                element.next = new ListNode(listNodes.poll());
                element = element.next;

            }
            return head;
        }


    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode[] ip = new ListNode[3];
        ip[0] = new ListNode(1);
        ip[0].next = new ListNode(4);
        ip[0].next.next = new ListNode(5);
        ip[0].next.next = new ListNode(45);

        ip[1] = new ListNode(2);
        ip[1].next = new ListNode(10);
        ip[1].next.next = new ListNode(11);
        ip[1].next.next = new ListNode(25);

        ip[2] = new ListNode(1);
        ip[2].next = new ListNode(6);
        ip[2].next.next = new ListNode(5);
        ip[2].next.next = new ListNode(15);
        solution.mergeKLists(ip);
    }
}
