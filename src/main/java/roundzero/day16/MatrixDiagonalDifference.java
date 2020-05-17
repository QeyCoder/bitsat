package roundzero.day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 02/11/17.
 */
public class MatrixDiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {


            String[] data = in.nextLine().split(" ");

            for (int j = 0; j < data.length; j++) {
                matrix[i][j] = Integer.parseInt(data[j]);
            }

        }

        long result = diff(matrix, n);
        System.out.println(result);
    }

    static int diff(int[][] matrix, int N) {


        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {

                if (i - j == 0) {
                    leftDiagonal += matrix[i][j];
                }
                if (i + j == N-1) {
                    rightDiagonal += matrix[i][j];
                }

            }
        }
        int dif = leftDiagonal - rightDiagonal;
        return dif > 0 ? dif : -dif;
    }
}
