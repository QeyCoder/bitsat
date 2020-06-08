package roundone;

import java.util.ArrayList;
import java.util.List;

public class Solution797 {

    static class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> finalans = new ArrayList<>();

            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            solve(graph, 0, ans, finalans);
            return finalans;
        }

        private void solve(int[][] graph, int i, List<Integer> ans, List<List<Integer>> finalans) {
            if (i == graph.length - 1) {
                finalans.add(ans);
                return;
            }

            for (int i1 : graph[i]) {
                ans.add(i1);
                solve(graph,i1, ans, finalans);
                ans.remove(ans.size()-1);
            }

        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.allPathsSourceTarget(new int[][]{
                {1, 2}, {3}, {3}, {}
        });
    }
}
