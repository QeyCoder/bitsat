package day15;

import code.Node;


/**
 * Created by Gaurav on 24/10/17.
 */
public class LinkedSwap {


    public static void main(String[] args) {


        Node<Integer> head = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        Node<Integer> node5 = new Node<Integer>(5);
        Node<Integer> node6 = new Node<Integer>(6);
        Node<Integer> node7 = new Node<Integer>(7);
        Node<Integer> node8 = new Node<Integer>(8);
        Node<Integer> node9 = new Node<Integer>(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;


        swap(head, 2, 9);


        reverse(head);
    }

    private static void reverse(Node<Integer> head) {
        Node<Integer> prev = null;
        Node<Integer> current = head;
        Node<Integer> next = head.next;

        while (current != null) {
            current.next = current;
            prev = current;

        }

    }


    private static void swap(Node<Integer> head, int val1, int val2) {

        Node<Integer> temp = null;
        Node<Integer> prevTemp = null;
        while (head != null) {
            head = head.next;
            if (head.data == val1) {
                temp = head;
            }
            if (temp != null && head.data == val2) {

            }
        }
        System.out.println("done");
    }


}
