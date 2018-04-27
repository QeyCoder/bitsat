package techgig;

import template.FastInputReader;

public class CandidateCode {


    static class Node {


        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) throws Exception {

        Node root = null;
        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();

        for (int i = 0; i < N; i++) {
            int ip = fastInputReader.readInt();
            if (ip == -1) {
                root = new Node(i);
            } else {
                insert(root, i, ip);
            }
        }
        int nodeToRemove = fastInputReader.readInt();
        removeNode(root, nodeToRemove);

        int ans = countLeaf(root);
        System.out.println(ans);
    }

    private static int countLeaf(Node root) {


        int ans = 0;
        if (root.left == null && root.right == null) {
            ans += 1;

        } else {
            if (root.left != null) {
                ans += countLeaf(root.left);
            }
            if (root.right != null) {
                ans += countLeaf(root.right);
            }
        }
        return ans;
    }

    private static void removeNode(Node root, int nodeToRemove) {


        if (root != null && root.left != null) {
            if (root.left.data == nodeToRemove) {
                root.left = null;
                return;
            }
            removeNode(root.left, nodeToRemove);
        }
        if (root != null && root.right != null) {
            if (root.right.data == nodeToRemove) {
                root.right = null;
                return;
            }
            removeNode(root.right, nodeToRemove);
        }


    }

    private static void insert(Node root, int val, int parent) {

        if (root.data == parent) {
            if (root.left == null) {
                root.left = new Node(val);
            } else {
                root.right = new Node(val);
            }
        }
        if (root.left != null)
            insert(root.left, val, parent);
        if (root.right != null)
            insert(root.right, val, parent);

    }
}