package roundzero.flipkart;

import java.util.*;

/**
 * Created by Gaurav on 19/03/18.
 */


public class VerticleOrderTraversal {

    static Map<Integer, List<Integer>> map = new TreeMap<>();

    static class Tree {
        int data;
        Tree left;
        Tree right;

        public Tree(int data) {
            this.data = data;
        }
    }

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
        Tree tweleve = new Tree(12);


        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        six.right = eight;
        seven.right = nine;
        seven.left =  ten;
        ten.right= eleven;
        eleven.right= tweleve;

        solution(root, 0);

        for (List<Integer> list : map.values()) {
            System.out.println(list);
        }
    }

    private static void solution(Tree root, int distance) {

        if (root != null) {
            List<Integer> values = map.get(distance);
            if (values == null) {
                values = new ArrayList<>();
            }
            values.add(root.data);
            map.put(distance, values);
            solution(root.left, distance - 1);
            solution(root.right, distance + 1);
        }

    }


}
