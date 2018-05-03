package leetCode;

/**
 * Created by Gaurav on 01/05/18.
 */


public class _206 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        Solution solution
                = new Solution();
        one
                .next = two;
        two.next = three;
        three.next = four;
        ListNode op = solution.reverseList(null);
        System.out.println();

    }

    //1->2->3->4->null
    static class Solution {
        public ListNode reverseList(ListNode head) {

            ListNode prev = null;
            ListNode current = head;
            ListNode next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }


            return prev;
        }

        public ListNode recusriveReverseList(ListNode head) {
            if(head !=null){
                ListNode prev = null;
                ListNode current = head;
                ListNode next = null;

                next = current.next;
                current.next = prev;
                prev = current;
                current = next;


                return prev;
            }
            return recusriveReverseList(head.next);


        }
    }

}
