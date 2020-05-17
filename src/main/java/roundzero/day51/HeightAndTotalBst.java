package roundzero.day51;

import roundzero.template.FastInputReader;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gaurav on 17/02/18.
 */
public class HeightAndTotalBst {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        Set<Integer> integers = new HashSet<>();
        Node root = new Node(fastInputReader.readInt());
        integers.add(root.data);
        for (int i = 1; i < n; i++) {
            int ip = fastInputReader.readInt();
            if (!integers.contains(ip)) {
                insert(root, ip);
            }
            integers.add(ip);

        }

        int maxHeight = maxHeight(root);

        int totalHeight = totalHeight(root);
        System.out.println(maxHeight);
        System.out.println(totalHeight);
    }

    private static int totalHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int self = maxHeight(root);
        int left = totalHeight(root.left);
        int right = totalHeight(root.right);
        //System.out.println("node->" + root + "-self" + self + "-left" + left + "-right" + right);
        return self + left + right;
    }

    private static int maxHeight(Node root) {
        if (root == null) {
            return -1;
        }
        return max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static void insert(Node root, int data) {

        if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
    }


    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
}
