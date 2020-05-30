package roundone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution785 {


    static class Solution {
        int N;

        public boolean isBipartite(int[][] graph) {
            N = graph.length;
            return solve(graph);
        }

        private boolean solve(int[][] graph) {
            boolean[] visited = new boolean[graph.length];
            int[] color = new int[graph.length];
            Arrays.fill(color, -1);
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < graph.length; i++) {
                color[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int element = queue.poll();
                    visited[element] = true;
                    for (int el : graph[element]) {
                        if (!visited[el]) {
                            if (color[el] == color[element]) {
                                return false;
                            }
                            if (color[element] == 1) {
                                color[el] = 0;
                            } else {
                                color[el] = 1;
                            }
                            queue.add(el);
                        }
                    }
                }
            }
            return true;


        }
    }

    public static void main(String[] args) {
//        new Solution().isBipartite(new int[][]
//
//                {{3}, {2, 4}, {1}, {0, 4}, {1, 3}}
//        );

        new Solution().isBipartite(new int[][]

                {{1, 3}, {0, 2}, {1, 3}, {0, 2}}
        );

    }

}
