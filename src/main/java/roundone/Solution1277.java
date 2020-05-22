package roundone;

public class Solution1277 {
    static class Solution {
        public int countSquares(int[][] matrix) {

            int[][] ans = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 || j == 0) {
                        ans[i][j] = matrix[i][j];
                    } else {
                        if (matrix[i][j] == 1) {
                            ans[i][j] = Math.min(Math.min(ans[i - 1][j - 1], ans[i][j - 1]), ans[i - 1][j]) + 1;
                        }
                    }
                }
            }
            int solution = 0;
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    if (ans[i][j] != 0) {
                        solution+=ans[i][j];
                    }
                }
            }
            return solution;
        }
    }


    public static void main(String[] args) {

        Solution solution
                = new Solution();
        solution.countSquares(new int[][]{
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                }
        );
    }


}
