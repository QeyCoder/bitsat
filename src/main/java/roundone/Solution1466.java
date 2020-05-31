package roundone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1466 {

    static class Solution {
        public int minReorder(int n, int[][] connections) {

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] connection : connections) {
                int src = connection[0];
                int dest = connection[1];
                adj.get(src).add(dest);
                adj.get(dest).add(-src);
            }

            boolean[] visited = new boolean[n];

            Queue<Integer> stack = new LinkedList<>();
            int ans = 0;
            stack.add(0);

            while (!stack.isEmpty()) {
                int element = stack.poll();
                int absElement = Math.abs(element);
                if (!visited[absElement]) {
                    visited[absElement] = true;
                    for (Integer tmp : adj.get(absElement)) {

                        if (tmp > 0 && !visited[tmp]) {
                            ans++;
                        }
                        stack.add(Math.abs(tmp));
                    }
                }
            }
            return ans;
        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}});
    }
}
