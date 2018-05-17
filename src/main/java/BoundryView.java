/**
 * Created by Gaurav on 16-05-2018.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BoundryView {


    public static void main(String[] args) {


        method(5);
    }

    private static void method(int i) {
        for (int j = 0; j < i; j++) {
            method(j);
        }
        System.out.println("value is " + i);
    }

    public static void smain(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BoundryView p = new BoundryView();
        p.boundryVIew(root);
    }

    private void boundryVIew(Node root) {


    }
}

//node structure of tree
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

// this class' represents the items stored in queue (used for level order
// traversal). Objects will store the nodes and its level
class QueuePack {
    int level;
    Node tnode;

    public QueuePack(int level, Node tnode) {
        this.level = level;
        this.tnode = tnode;

    }
}
