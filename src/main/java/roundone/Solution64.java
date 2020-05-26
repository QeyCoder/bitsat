package roundone;

public class Solution64 {

    static class Solution {
        public int minPathSum(int[][] grid) {
//            return solve(grid, 0, 0, grid.length - 1, grid[0].length - 1);
            return solve(grid);
        }

        private int solve(int[][] grid, int i, int j, int m, int n) {
            if (i >= m || j > n) {
                return Integer.MAX_VALUE;
            }
            if (i == m && j == n) {
                return grid[i][j];
            }
            return Math.min(solve(grid, i + 1, j, m, n), solve(grid, i, j + 1, m, n)) + grid[i][j];
        }

        private int solve(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j != 0) {
                        grid[i][j] = grid[i][j] + grid[i][j - 1];
                    } else if (i != 0 && j == 0) {
                        grid[i][j] = grid[i][j] + grid[i - 1][j];
                    } else if (i == 0 && j == 0) {
                        //TODO nothing
                    } else {
                        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                    }
                }
            }
            return grid[m - 1][n - 1];
        }

    }


    public static void main(String[] args) {
        int ans = new Solution().minPathSum(new int[][]{{3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3}, {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2}, {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9}, {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7}, {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8}, {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9}, {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1}, {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3}, {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3}, {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8}, {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3}, {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3}, {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3}, {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5}, {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2}, {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0}, {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0}, {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}});
//        int ans = new Solution().minPathSum(new int[][]{{1,2},{3,4},{5,6}});
        System.out.println(ans);
    }
}
