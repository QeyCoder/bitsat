package day71;

/**
 * Created by Gaurav on 27/04/18.
 */


public class LinkLIstCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {

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
        five.next = six;
        six.next = seven;
        seven.next = three;

        System.out.println(detectCycle(one));


    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;


        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                fast = fast.next;
                int count = 1;
                while (slow != fast) {
                    fast = fast.next;
                    count++;
                }

                slow = head;

                fast =  head;
                while (count-- > 0) {
                    fast = fast.next;
                }

                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;


            }
        }
        return null;

    }

}
