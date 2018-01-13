package day36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gaurav on 01/01/18.
 */
//https://www.hackerrank.com/challenges/even-tree
public class EvenTree {

    static class Node {
        int data;
        List<Node> child;
        int size;
        public Node(int data) {
            this.data = data;
        }

        public List<Node> getChild() {
            return child == null ? child = new ArrayList<>() : child;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        Node root = new Node(1);
        for (int i = 0; i < M; i++) {
            String[] edge = bufferedReader.readLine().split(" ");
            int A = Integer.parseInt(edge[0]);
            int B = Integer.parseInt(edge[1]);
            Node dest = findNode(root, A);
            Node src = findNode(root, B);
            if (src == null) {
                src = new Node(B);
            }

            if (dest == null) {
                dest = new Node(A);
            }

            src.getChild().add(dest);
        }

        System.out.println(solution(root));


    }

    private static int solution(Node root) {
        int count = 0;
        Stack<Node>  nodeStack  =  new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.empty()){
            Node popped = nodeStack.pop();
            if(popped.getChild().size()!=0 && popped.getChild().size()%2==0){
                count++;
            }
            for (Node temp : popped.getChild()) {
                nodeStack.push(temp);
            }
        }
        return count;
    }


    private static Node findNode(Node root, int b) {
        if (root.data == b) {
            return root;
        } else {
            List<Node> childrens = root.getChild();
            for (Node children : childrens) {
                Node node = findNode(children, b);
                if (node != null) {
                    return node;
                }
            }
        }
        return null;
    }

}
