package day36;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Gaurav on 25/12/17.
 */
public class BFS {

//DFS use stack instead of queue
    static class Graph {
        private int noOfEdges;

        LinkedList<Integer>[] adjList;

        public Graph(int noOfEdges) {
            this.noOfEdges = noOfEdges;
            adjList =  new LinkedList[noOfEdges];
            for (int i = 0; i < noOfEdges; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int weight) {
            adjList[src].add(weight);
        }

        public void BFS(int src) {
            boolean visited[] = new boolean[noOfEdges];
            LinkedList<Integer> queue = new LinkedList<>();
            visited[src] = true;
            queue.add(src);

            while (queue.size() != 0) {
                src = queue.poll();
                System.out.println("node " + src);
                ListIterator<Integer> iterator = adjList[src].listIterator();
                while (iterator.hasNext()) {
                    int data = iterator.next();
                    if (!visited[data]) {
                        visited[data] = true;
                        queue.add(data);
                    }
                }


            }


        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS (starting from vertex 2)");

        g.BFS(2);

    }
}
