package roundone;

import roundone.helper.TopologicalSort;
import roundone.helper.graph.Graph;

public class Solution207 {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            boolean[] visited = new boolean[numCourses];
            Graph<Integer> graph = new Graph<>(true, false);
            for (int i = 0; i < prerequisites.length; i++) {
                int src = prerequisites[i][0];
                int dest = prerequisites[i][1];
                graph.addEdge(src, dest);
            }

            TopologicalSort<Integer> integerTopologicalSort =  new TopologicalSort<>(graph);
            integerTopologicalSort.sort();
         return false;
        }
    }

    public static void main(String[] args) {
        new Solution().canFinish(2, new int[][]{{1, 0}, {0, 1}});
    }

}
