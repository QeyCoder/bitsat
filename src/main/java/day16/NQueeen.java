package day16;

/**
 * Created by Gaurav on 22/11/17.
 */
public class NQueeen {

    public static void main(String[] args) {


        InputReader inputReader
                = new InputReader(System.in);
        System.out.println("Board Size [for 4X4 enter 4]");


        int N = inputReader.nextInt();
        if (N < 4) {
            System.out.println("Minimum matrix size is 4");
            return;
        }

        solution(N);

    }

    private static void solution(int n) {
        int[][] board = new int[n][n];
        if (putQueen(board, 0, n)) {
            System.out.println("yes");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean putQueen(int[][] board, int queen, int max) {

        for (int i = 0; i < max; i++) {
            if (!isClashing(board, i,queen)) {
                board[queen][i] = 1;
                if (putQueen(board, queen + 1, max)) {
                    return true;
                }
                board[queen][i] = 0;
            }
        }
        return false;
    }

    private static boolean isClashing(int[][] board, int row, int column) {

        // if placement is clashing

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1)
                return true;

        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 1)
                return true;

        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {


                if (i + j == row + column && board[i][j] == 1) {
                    return true;
                }

                if (Math.abs(i - j) == Math.abs(row - column) && board[i][j] == 1) {
                    return true;
                }

            }

        }

        return false;
    }

    public static void meain(String[] args) {

        int [][] bo = new int[4][4];
        bo[0][1] = 1;
        bo[2][3] = 1;



        System.out.println(isClashing(bo, 1, 3));
        System.out.println(isClashing(bo, 1, 1));
        System.out.println(isClashing(bo, 2, 1));

    }

}
