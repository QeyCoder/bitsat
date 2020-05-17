package day35;

/**
 * Created by Gaurav on 17/12/17.
 */
public class GraphPath {

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        g.printAllPath(2, 3);
    }

    static class Graph {
        int vertexCount;
        int[][] graph;

        public Graph(int vertex) {
            this.vertexCount = vertex;
            graph = new int[vertex][vertex];
            for (int i = 0; i < vertexCount; i++) {
                graph[i][i] = 1;
            }
        }


        public void addEdge(int source, int destination) {
            graph[source][destination] = 1;
        }

        public void printAllPath(int source, int destination) {
            boolean[] arr = new boolean[vertexCount];

            printPath(source, destination, arr,0
            );


        }

        private int printPath(int src, int destination, boolean[] arr, int count) {
            arr[src] = true;
            if (src == destination) {
                return count++;
            }else{
             /*   for (int i =0 ; i <graph[].length ; i++) {

                }*/
            }
            return src;
        }

    }
}
