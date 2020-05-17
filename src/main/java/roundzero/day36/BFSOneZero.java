package roundzero.day36;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/bfsshortreach/problem
class BFSOneZero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            //nodes
            int n = in.nextInt();
            Graph graph = new Graph(n);
            //edges
            int m = in.nextInt();

            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph.addEdge(u-1, v-1);
            }
            int s = in.nextInt();
            System.out.println(solution(graph, s-1));
        }
        in.close();
    }

    private static boolean solution(Graph graph, int startNode) {

        Deque<Integer> queue =  new LinkedList<>();




        return false;
    }


    static class Graph {
        private int noOfEdges;

        int[][] graph;

        public Graph(int noOfEdges) {
            this.noOfEdges = noOfEdges;
            graph = new int[noOfEdges][noOfEdges];
        }

        public void addEdge(int src, int destination) {
            graph[src][destination] = 1;
            graph[destination][src] = 1;
        }
    }
}
