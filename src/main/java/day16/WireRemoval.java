package day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 08/11/17.
 */
public class WireRemoval {


    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Tree tree = new Tree();
        for (int a0 = 0; a0 < n - 1; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            tree.insert(x, y);

        }

        tree.childCount();
        //DecimalFormat dc = new DecimalFormat("#0.00000");
        //System.out.println(dc.format(tree.solution()));
        System.out.println(tree.solution());

        in.close();

    }

    static class Tree {
        WireNode root;

        void insert(int parent, int child) {
            if (parent == 1 && root == null) {
                root = new WireNode(parent);
            }
            WireNode node = find(root, parent);

            if (node != null) {
                WireNode ch = new WireNode(child);
                if (node.left == null) {
                    node.left = ch;
                } else if (node.right == null) {
                    node.right = ch;
                }
            }
        }

        private WireNode find(WireNode node, int value) {

            if (node == null) {
                return null;
            }
            if (node.data == value) {
                return node;
            } else {
                WireNode child = find(node.left, value);
                if (child == null) {
                    child = find(node.right, value);
                }
                return child;
            }
        }

        public double solution() {
            double num = getNumenator(root, 0);
            double den = getDenomantor(root, 0);
            return num / den;
        }

        private double getDenomantor(WireNode temp, int depth) {
            if (temp != null)
                return depth + getDenomantor(temp.left, depth + 1) + getDenomantor(temp.right, depth + 1);
            return 0d;

        }

        private double getNumenator(WireNode temp, int depth) {
            if (temp != null) {
                return (root.childCount - temp.childCount) * depth + getNumenator(temp.left, depth + 1) + getNumenator(temp.right, depth + 1);
            }
            return 0d;
        }

        void childCount() {
            childCount(root);
        }

        public int childCount(WireNode temp) {
            if (temp != null) {
                int leftCount = childCount(temp.left);
                int rightCount = childCount(temp.right);
                temp.childCount = leftCount + rightCount + 1;
                return temp.childCount;
            }
            return 0;
        }

        static class WireNode {
            int data;
            WireNode left;
            WireNode right;
            int childCount;

            WireNode(int data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return "data:" + data;
            }
        }
    }
}