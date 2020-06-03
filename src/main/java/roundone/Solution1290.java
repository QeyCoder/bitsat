package roundone;

import java.util.Stack;

public class Solution1290 {
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
        //        public int getDecimalValue(ListNode head) {
//
//
//            Stack<ListNode> storage = new Stack<>();
//
//            while (head != null) {
//                storage.add(head);
//                head = head.next;
//            }
//
//            int i = 0;
//            int ans = 0;
//            while (!storage.isEmpty()) {
//                ListNode element = storage.pop();
//                ans += element.val *1 << i;
//                i++;
//            }
//            return ans;
//        }
        //copied //TODO need to learn this
        public int getDecimalValue(ListNode head) {
            int num = 0;
            while (head != null) {
                num = num * 2 + head.val;
                head = head.next;
            }
            return num;
        }
    }

    public static void main(String args[]) {

        System.out.println(5 << 2);
        Solution solution = new Solution();
        ListNode head  = new ListNode(1);
        head.next= new ListNode(1);
        head.next.next =  new ListNode(0);
        solution.getDecimalValue(head);
    }
}
