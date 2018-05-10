package codeFight;

/**
 * Created by Gaurav on 04/05/18.
 */


public class RemoveKElement {


    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> one = new ListNode<>(2);
        ListNode<Integer> two = new ListNode<>(2);
        ListNode<Integer> three = new ListNode<>(3);
        ListNode<Integer> four = new ListNode<>(4);
        ListNode<Integer> five = new ListNode<>(5);
        ListNode<Integer> six = new ListNode<>(6);
        ListNode<Integer> seven = new ListNode<>(1);
        ListNode<Integer> eight = new ListNode<>(2);
        ListNode<Integer> nine = new ListNode<>(2);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = null;
        removeKFromList(one, 2);

    }

    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        ListNode<Integer> prev = null;
        ListNode<Integer> current = l;

        while (current != null) {
            if (prev == null && current.value == k) {
                current.next = current.next.next;
            } else if (prev != null && current.value == k) {
                prev.next = current.next;
                current = current.next;
            } else {
                current = current.next;
            }
        }
        return l;

    }


}
