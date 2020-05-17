package roundzero.day16;

/**
 * Created by Gaurav on 28/10/17.
 */
public class DoublyLinkListUsingSinglePointer {


    Node head;

    class Node {
        int data;
        Node np;
    }

    public static void main(String[] args) {

    }

    void insert(Node node) {
        if (head == null) {
            head = node;
            return;
        }


        while (head.np!=null){
            head =  head.np;
        }



    }
}
