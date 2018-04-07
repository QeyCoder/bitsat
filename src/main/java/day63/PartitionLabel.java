package day63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Gaurav on 07/04/18.
 */


public class PartitionLabel {

    static class Node {
        private char c;
        int start = -1;
        int end = -1;

        public Node(char c, int s, int e) {
            this.start = s;
            this.end = e;
            this.c = c;
        }

        @Override
        public String toString() {
            return Character.toString(c);
        }
    }

    public static void main(String[] args) {


        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {


        Node[] nodes = new Node[26];


        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            Node node = nodes[index];
            if (node == null) {
                node = new Node((char) ('a' + index), +i, i);
            } else {
                node.end = i;
            }
            nodes[index] = node;

        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1 == null && o2 != null) {
                    return 1;
                }
                if (o2 == null && o1 != null) {
                    return -1;
                }
                if (o2 == null && o1 == null) {
                    return -1;
                }
                return o1.start - o2.start;
            }
        });


        List<Integer> list = new ArrayList<>();

        int end = -1;

        for (int i = 0; i < nodes.length; i++) {

            Node node = nodes[i];
            if (node != null && node.start > end) {
                list.add(node.end - node.start + 1);
                end = node.end;
            } else {
                if (node != null && node.start < end && node.end > end) {
                    int diff = node.end - end;
                    Integer element = list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.add(diff + element);
                    end = node.end;
                }
            }
        }
        return list;
    }

}
