package roundone;

import java.util.HashSet;
import java.util.Set;

public class Solution83 {

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
        //TODO in case list is not sorted this will work
        public ListNode deleteDuplicates(ListNode head) {

            Set<Integer> storage = new HashSet<>();
            ListNode tmp = head;
            while (head != null) {
                storage.add(head.val);
                if (head.next != null) {
                    if (storage.contains(head.next.val)) {
                        head.next = head.next.next;
                    }else{
                        head = head.next;
                    }
                } else {
                    head = head.next;
                }
            }
            return tmp;

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(1);
        four.next=five;
        three.next=four;
        two.next=three;
        one.next =  two;
        solution.deleteDuplicates(one);
    }
}
