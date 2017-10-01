package day4;

import java.util.Stack;

/**
 * Created by Gaurav on 01/10/17.
 */
public class BinaryTree {

    private Node root;

    void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(data, root);
        }
    }

    public Node insert(int data, Node rootNode) {
        if (data < rootNode.getVal()) {
            if (rootNode.getLeft() != null) {
                rootNode.setLeft(insert(data, rootNode.getLeft()));
            } else {
                rootNode.setLeft(new Node(data));
            }
        } else {
            if (rootNode.getRight() != null) {
                rootNode.setRight(insert(data, rootNode.getRight()));
            } else {
                rootNode.setRight(new Node(data));
            }
        }

        return rootNode;
    }


    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node root) {

        if (root.getLeft() != null) {
            printPreOrder(root.getLeft());
        }
        if (root != null) {
            System.out.println(root.getVal());
        }
        if (root.getRight() != null) {
            printPreOrder(root.getRight());
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }


    private void printPreOrder(Node root) {
        if (root != null) {
            System.out.println(root.getVal());
        }
        if (root.getLeft() != null) {
            printPreOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            printPreOrder(root.getRight());
        }
    }

    private void printPostOrder(Node root) {


        if (root.getLeft() != null) {
            printPreOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            printPreOrder(root.getRight());
        }
        if (root != null) {
            System.out.println(root.getVal());
        }
    }


    public void recursiveInOrder() {
        recursiveInOrder(root);
    }

    private void recursiveInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.getLeft();
        }
        while (stack.size() > 0) {
            Node popedNode = stack.pop();
            System.out.println(popedNode.getVal());
            if (popedNode.getRight() != null) {
                root = popedNode.getRight();
                while (root != null) {
                    stack.push(root);
                    root = root.getLeft();
                }

            }
        }
    }

    public void iterativePreOrder() {
        iterativePreOrder(root);
    }

    private void iterativePreOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            if (root != null) {
                System.out.println(root.getVal());
            }

            if (root != null && root.getLeft() != null) {
                stack.push(root.getLeft());
            }
            if (root != null && root.getRight() != null) {
                stack.push(root.getRight());
            }
        }

    }
}
