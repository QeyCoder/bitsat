package roundone;

import roundzero.javaPrep.Array;

import java.util.Arrays;

public class Solution74 {

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {


            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length > 0) {

                    if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                        return binarySearch(matrix[i], target, 0, matrix[i].length);
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }

        boolean binarySearch(int[] matrix, int target, int low, int high) {

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target < matrix[mid]) {
                    high = mid - 1;

                } else if (target > matrix[mid]) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution
                = new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}, {55, 89, 196, 500}}
                , 500
        ));

    }
}
