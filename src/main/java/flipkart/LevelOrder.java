package flipkart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Gaurav on 12/03/18.
 */


public class LevelOrder {


    public static void main(String[] args) {


        Tree root = new Tree(1);
        Tree two = new Tree(2);
        Tree three = new Tree(3);
        Tree four = new Tree(4);
        Tree five = new Tree(5);
        Tree six = new Tree(6);
        Tree seven = new Tree(7);
        Tree eight = new Tree(8);
        Tree nine = new Tree(9);
        Tree ten = new Tree(10);
        Tree eleven = new Tree(11);


        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        four.left = eight;
        four.right = nine;
        five.left = ten;
        five.right = eleven;


//        levelOrder(root);
        //      reverseLeveOrder(root);
        spiralOrder(root);


    }

    private static void spiralOrder(Tree root) {

        Stack<Tree> stack1 = new Stack<>();
        Stack<Tree> stack2 = new Stack<>();
        stack1.add(root);

        StringBuilder stringBuilder
                = new StringBuilder();
        stringBuilder.append("spiralOrder\n");
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Tree in1 = stack1.pop();
                if (in1 != null) {
                    stringBuilder.append(in1.data).append(" ").append("\n");
                    stack2.add(in1.right);
                    stack2.add(in1.left);

                }
            }
            while (!stack2.isEmpty()) {
                Tree in2 = stack2.pop();
                if (in2 != null) {
                    stringBuilder.append(in2.data).append(" ").append("\n");
                    stack1.add(in2.left);
                    stack1.add(in2.right);
                }
            }

        }
        System.out.println(stringBuilder);

    }

    private static void reverseLeveOrder(Tree root) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reverseLeveOrder\n");
        Queue<Tree> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {

            Tree op = queue.poll();
            if (op != null) {
                stringBuilder.append(op.data).append("->\n").append("\n");
                queue.add(op.right);
                queue.add(op.left);

            }

        }
        System.out.println(stringBuilder);

    }

    private static void levelOrder(Tree root) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("levelOrder\n");
        Queue<Tree> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {

            Tree op = queue.poll();
            if (op != null) {
                queue.add(op.left);
                queue.add(op.right);
                stringBuilder.append(op.data).append("->\n").append("\n");
            }

        }
        System.out.println(stringBuilder);
    }

    static class Tree {
        private int data;
        private Tree left;
        private Tree right;

        public Tree(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }


}
