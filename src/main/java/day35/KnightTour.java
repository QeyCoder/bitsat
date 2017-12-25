package day35;

/**
 * Created by Gaurav on 20/12/17.
 */
public class KnightTour {

    static int[] xMoves = {1, 1, -1, -1, -2, -2, 2, 2};
    static int[] yMoves = {2, -2, 2, -2, 1, -1, -1, 1};

    public static void main(String[] args) {
        int[][] matrix = new int[8][8];
        int X = 0;
        int Y = 0;
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -1;
            }
        }
        matrix[X][Y] = 0;
        solution(size, matrix, X, Y, 0);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

    }

    private static boolean solution(int size, int[][] matrix, int x, int y, int move) {
//        if (matrix[x][y] != 0) {
//            return false;
//        }
        if (move == size * size - 1) {
            // if we are here means we have solved the problem
            return true;
        }
        for (int i = 0; i < size; i++) {
            int xnew = x + xMoves[i];
            int ynew = y + yMoves[i];

            if (isSafe(size, matrix, xnew, ynew)) {
                matrix[xnew][ynew] = ++move;
                if (solution(size, matrix, xnew, ynew, move)) {
                    return true;
                } else {
                    matrix[x][y] = -1;
                    move--;
                }
            }
        }
        return false;
    }



    static boolean isSafe(int size, int[][] matrix, int x, int y) {

        if (x < 0 || x > size - 1 || y < 0 || y > size - 1|| matrix[x][y]!=-1) {
            return false;
        }
        return true;
    }
}
