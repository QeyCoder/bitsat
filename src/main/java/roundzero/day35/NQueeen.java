package day35;


import java.util.Scanner;

/**
 * Created by Gaurav on 22/11/17.
 */
public class NQueeen {

    public static void main(String[] args) throws InterruptedException {


        Scanner inputReader
                = new Scanner(System.in);
        System.out.println("Board Size [for 4X4 enter 4]");


        int N = inputReader.nextInt();
        if (N < 4) {
            System.out.println("Minimum matrix size is 4");
            return;
        }
        int[][] chessBoard = new int[N][N];
        boolean sol = solution(chessBoard, 0);
        if (sol) {
            print(chessBoard);
        } else {
            System.out.println("No solution");
        }

    }

    private static void print(int[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    private static boolean solution(int[][] chessBoard, int col) throws InterruptedException {
        int boardSize = chessBoard.length;
        if (col == boardSize) {
            print(chessBoard);
            return true;
        } else {
            for (int i = 0; i < boardSize; i++) {
                if (!isClashing(chessBoard, i, col) == true) {
                    chessBoard[i][col] = 1;
                    solution(chessBoard, col + 1);
                    chessBoard[i][col] = 0;
                }
            }
        }
        return false;
    }

    static boolean isClashing(int[][] chessboard, int row, int col) {


        //check for row clash

        for (int i = 0; i < col; i++) {
            if (chessboard[row][i] == 1) {
                return true;
            }
        }
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {

                if (i + j == row + col || i - j == row - col) {
                    if ((i != row || j != col) && chessboard[i][j] == 1)
                        return true;
                }

            }
        }
        return false;

    }

}
