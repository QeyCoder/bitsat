package day64;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Gaurav on 08/04/18.
 */


public class RedundantEdge {


    public static void main(String[] args) {


        //int[] op = findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});
        int[] op = findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}});
        //op = findRedundantConnection2(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});

        for (int i = 0; i < op.length; i++) {
            System.out.println(op[i]);
        }
    }

    private static int[] findRedundantConnection2(int[][] edges) {


        LinkedList<Integer>[] lists = new LinkedList[edges.length];

        for (int i = 0; i < edges.length; i++) {
            lists[i] = new LinkedList<>();
        }
        int[] result = new int[0];
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            if (dfs(src, dest, lists)) {
                result = new int[]{src, dest};
            } else {
                lists[src].add(dest);
            }


        }
        return result;

    }


    static boolean dfs(int src, int des, LinkedList<Integer>[] lists) {


        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);


        while (!queue.isEmpty()) {
            Integer op = queue.poll();
            LinkedList<Integer> neigh = lists[op];
            for (int i = 0; i < neigh.size(); i++) {
                Integer dest = neigh.get(i);
                if (dest == des) {
                    return true;
                }
                queue.add(neigh.get(i));
            }
        }
        return false;


    }


    public static int[] findRedundantConnection(int[][] edges) {
        DisjoinSet<Integer> disjoinSet = new DisjoinSet<>();

        int[] result = new int[0];
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            DisjoinSet<Integer>.Node<Integer> srcS = disjoinSet.findSet(src);
            DisjoinSet<Integer>.Node<Integer> desS = disjoinSet.findSet(dest);

            if (srcS == null) {
                disjoinSet.makeSet(src);
                srcS = disjoinSet.findSet(src);
            }
            if (desS == null) {
                disjoinSet.makeSet(dest);
                desS = disjoinSet.findSet(dest);
            }


            if (srcS.parent == desS.parent) {
                result = new int[]{src, dest};
            } else {
                disjoinSet.union(src, dest);
            }

        }
        return result;


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
