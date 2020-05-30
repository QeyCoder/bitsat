package roundone;

import roundone.helper.graph.Graph;
import roundone.helper.graph.Vertex;

public class Solution743 {

    class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {

            Graph<Integer> graph = new Graph<>(true,true);
            for (int i = 0; i <N ; i++) {
                int src = times[i][0];
                int des = times[i][1];
                int w = times[i][2];
                graph.addEdge(src,des,w);
            }
            Vertex<Integer> vertex = graph.getVertex(K);




            return 0;
        }
    }
}
