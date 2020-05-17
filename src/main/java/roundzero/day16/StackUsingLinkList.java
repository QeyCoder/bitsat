package roundzero.day16;

import roundzero.code.Node;

/**
 * Created by Gaurav on 28/10/17.
 */
public class StackUsingLinkList {

    Node head;
    Node tail;

    void push(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        head = node;
        head.next = temp;
        head.next.prev = head;

    }

    Node pop() throws Exception {
        if (head != null && head.next != null) {
            Node temp = head;
            head = head.next;
            head.prev = null;
            return temp;
        }
        throw new Exception("oh boy");
    }


    public static void main(String[] args) throws Exception {


        Node<String> a = new Node("a");
        Node<String> b = new Node("b");
        Node<String> c = new Node("c");
        Node<String> d = new Node("d");
        Node<String> e = new Node("e");


        StackUsingLinkList stackUsingLinkList = new StackUsingLinkList();
        stackUsingLinkList.push(a);
        stackUsingLinkList.push(b);
        stackUsingLinkList.push(c);
        stackUsingLinkList.push(d);
        stackUsingLinkList.push(e);
        System.out.println(stackUsingLinkList.pop());
        System.out.println(stackUsingLinkList.pop());
        System.out.println(stackUsingLinkList.pop());
        System.out.println(stackUsingLinkList.pop());
        System.out.println(stackUsingLinkList.pop());

        System.out.println(stackUsingLinkList.pop());
        System.out.println(stackUsingLinkList.pop());
        System.out.println(stackUsingLinkList.pop());
        System.out.println(stackUsingLinkList.pop());



        System.out.println("done");


    }
}
