package roundone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1029 {
    static class Solution {
        public int twoCitySchedCost(int[][] costs) {

            Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));

            int cost = 0;
            for (int i = 0; i < costs.length; i++) {

                if (i < costs.length / 2) {
                    cost += costs[i][0];
                } else {
                    cost += costs[i][1];
                }

            }
            return cost;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}});
    }
}
