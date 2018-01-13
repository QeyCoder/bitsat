package day36;


import helper.DisJointSet;
import helper.Edge;
import helper.Graph;
import helper.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class KruskalSpecialTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        Graph<Integer> graph = new Graph(false);
        for (int i = 0; i < m; i++) {
            data = in.nextLine().split(" ");
            int sN = Integer.parseInt(data[0]);
            int dN = Integer.parseInt(data[1]);
            int w = Integer.parseInt(data[2]);
            graph.addEdge(sN, dN, w);

        }
        solution(graph);
    }

    private static List<Edge<Integer>> solution(Graph<Integer> graph) {
        List<Edge<Integer>> edges = graph.getEdgeList();
        GraphComparator graphGraphComparator = new GraphComparator();
        edges.sort(graphGraphComparator);
        DisJointSet disJointSet = new DisJointSet();
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            disJointSet.makeSet(vertex.getId());
        }
        List<Edge<Integer>> resultSet = new ArrayList<>();
        for (Edge<Integer> edge : edges) {


            long srcR = (long) disJointSet.findSet(edge.getSrc().getId());
            long destR = (long) disJointSet.findSet(edge.getDest().getId());

            if (srcR == destR) {
                continue;
            } else {
                resultSet.add(edge);
                disJointSet.union(srcR, destR);
            }

        }
        return resultSet;


    }


    private static class GraphComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> o1, Edge<Integer> o2) {
            if (o1.getWeight() < o2.getWeight()) {
                return -1;
            } else if (o1.getWeight() > o2.getWeight()) {
                return 1;
            } else {
                long w1 = o1.getSrc().getId() + o1.getDest().getId() + o1.getWeight();
                long w2 = o2.getSrc().getId() + o2.getDest().getId() + o2.getWeight();
                if (w1 > w2) {
                    return 1;
                } else if (w2 > w1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    public static void mains(String args[]) {
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);
        List<Edge<Integer>> result = solution(graph);
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getSrc() + " " + edge.getDest());
        }
    }
}
