package roundone;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution973 {

    static class Solution {
        class Helper {
            int x;
            int y;
            double dist;

            public Helper(int x, int y) {
                this.x = x;
                this.y = y;
                this.dist = Math.sqrt(x * x + y * y);
            }

            @Override
            public String toString() {
                return String.valueOf(dist);
            }
        }

        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<Helper> heap = new PriorityQueue<>(Comparator.comparingDouble(o -> o.dist));
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                heap.add(getItem(x, y));
            }
            int[][] ans = new int[K][2];
            for (int i = 0; i < K; i++) {
                Helper item = heap.remove();
                ans[i][0] = item.x;
                ans[i][1] = item.y;
            }
            return ans;
        }

        private Helper getItem(int x, int y) {
            return new Helper(x, y);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.kClosest(new int[][]{{1,3},{-2,2}},1);
    }
}
