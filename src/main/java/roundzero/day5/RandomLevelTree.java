package day5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Asked in Line Assignment
 * Created by Gaurav on 02/10/17.
 */
public class RandomLevelTree {

    public static void main(String[] args) {
        RandomLevelTree levelOrderTree = new RandomLevelTree();

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;


        System.out.println(levelOrderTree.levelOrderTree(a));

    }

    /**
     * @param node
     * @return list in levelorder
     */
    List<Node> levelOrderTree(Node node) {
        List<Node> levelorder = new LinkedList<>();
        Queue<Node> data = new LinkedList<>();

        data.add(node);
        while (!data.isEmpty()) {
            Node popedNode = data.poll();
            if (popedNode != null) {
                levelorder.add(popedNode);
            }
            if (popedNode.left != null) {
                data.add(popedNode.left);
            }
            if (popedNode.right != null) {
                data.add(popedNode.right);
            }
        }
        return levelorder;
    }

    static class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }
}
