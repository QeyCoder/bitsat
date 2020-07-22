package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1219 {

    public static void main(String[] args) {
        new Solution().getMaximumGold(new int[][]{{1, 0, 7, 0, 0, 0}, {2, 0, 6, 0, 1, 0}, {3, 5, 6, 7, 4, 2}, {4, 3, 1, 0, 2, 0}, {3, 0, 5, 0, 20, 0}});
    }

    static class Solution {
        public int getMaximumGold(int[][] grid) {

            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] > 0) {
                        sum = Math.max(sum, grid[i][j] + solve(grid, i, j));
                    }
                }

            }
            return sum;

        }

        private int solve(int[][] grid, int x, int y) {
            int[] path = new int[]{0, 1, 0, -1, 0};
            int result = 0;


            int data = grid[x][y];
            grid[x][y] = 0;


            for (int i = 0; i < 4; i++) {

                int a = x + path[i];
                int b = y + path[i + 1];
                if (a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && grid[a][b] != 0) {
                    result = Math.max(result, grid[a][b] + solve(grid, a, b));
                }

            }
            grid[x][y] = data;
            return result;

        }
    }
}



