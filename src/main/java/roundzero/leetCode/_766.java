package leetCode;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _766 {


    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {

            int row = matrix.length;
            int col = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i > 0 && i < row && j > 0 && j < row && matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
            }
            return true;

        }
    }

    public static void main(String[] args) {
        Solution solution
                = new Solution();

        System.out.println(solution.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));

    }
}
