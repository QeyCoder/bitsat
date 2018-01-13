package day36;

/**
 * Created by Gaurav on 01/01/18.
 */
public class EditDistance {

    public int minDistance(String A, String B) {
        int[][] matrix = new int[A.length() + 1][A.length() + 1];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {

                if (i == 0) {
                    matrix[i][j] = j;
                }
                if (j == 0) {
                    matrix[i][j] = i;
                } else if (A.charAt(i - 1) == A.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]);
                }
            }
        }
        return matrix[A.length()][B.length()];
    }
}
