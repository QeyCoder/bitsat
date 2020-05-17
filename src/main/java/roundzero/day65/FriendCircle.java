package day65;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaurav on 09/04/18.
 */

//https://leetcode.com/problems/friend-circles/description/
public class FriendCircle {


    public static void main(String[] args) {

        FriendCircle friendCircle = new FriendCircle();
        System.out.println(friendCircle.findCircleNum(new int[][]{{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}}));
        System.out.println(friendCircle.findCircleNum(new int[][]
                {{1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1}}));
        System.out.println(friendCircle.findCircleNum(new int[][]{{1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}}
        ));
    }

    public int findCircleNum(int[][] M) {
        int total = M.length;
        DisjoinSet<Integer> disjoinSet = new DisjoinSet();
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int relation = M[i][j];

                if (relation == 1) {
                    DisjoinSet<Integer>.Node<Integer> setA = disjoinSet.findSet(i);
                    DisjoinSet<Integer>.Node<Integer> setB = disjoinSet.findSet(j);

                    if (setA == null) {
                        disjoinSet.makeSet(i);
                    }

                    if (setB == null) {
                        disjoinSet.makeSet(j);
                    }

                    if (disjoinSet.union(i, j)) {
                        total--;

                    }
                }
            }
        }

        return total;

    }

    static class DisjoinSet<T> {

        Map<T, Node<T>> nodeMap = new HashMap<>();

        class Node<T> {
            T data;
            int rank = 0;
            Node parent;

            @Override
            public String toString() {
                return data.toString();
            }
        }


        void makeSet(T data) {
            Node node = new Node();
            node.data = data;
            node.parent = node;
            nodeMap.put(data, node);
        }


        boolean union(T a, T b) {
            Node<T> aNode = nodeMap.get(a);
            Node<T> bNode = nodeMap.get(b);

            Node<T> aParent = findSet(aNode);
            Node<T> bParent = findSet(bNode);

            if (aParent == bParent) {
                return false;
            } else {
                if (aParent.rank >= bParent.rank) {
                    aParent.rank = (aParent.rank == bParent.rank) ? aParent.rank + 1 : aParent.rank;
                    bParent.parent = aParent;
                } else {
                    aParent.parent = bParent;
                }
            }
            return true;
        }

        private Node<T> findSet(Node<T> aNode) {
            if (aNode == null) {
                return null;
            }
            Node parent = aNode.parent;

            if (parent == aNode) {
                return aNode;
            } else {
                return findSet(aNode.parent);
            }
        }

        Node<T> findSet(T t) {
            return findSet(nodeMap.get(t));
        }


    }

}
