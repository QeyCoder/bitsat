package roundone;

//Sudoku SOlver
public class Solution37 {

    static class Solution {
        public void solveSudoku(char[][] board) {


            solveIt(board);

        }

        private boolean solveIt(char[][] board) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (int k = 1; k <= 9; k++) {
                            char kc =Character.forDigit(k,10);
                            if (canSolve(board, i, j,kc )) {
                                char tmp = board[i][j];
                                board[i][j] = kc;
                                if (solveIt(board)) {
                                    return true;
                                }
                                board[i][j] = tmp;
                            }

                        }
                        return false;
                    }
                }
            }

            return true;
        }


        private boolean canSolve(char[][] board, int row, int col, char k) {


            for (int l = 0; l < board.length; l++) {
                if (board[row][l] == k || board[l][col] == k) {
                    return false;
                }

            }


            for (int i = row - (row % 3), x = 0; x < 3; i++, x++) {
                for (int j = col - (col % 3), l = 0; l < 3; j++, l++) {
                    if (board[i][j] == k) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] ip = {
                {'4', '1', '.', '.', '6', '5', '.', '.', '7'},
                {'.', '.', '6', '.', '.', '7', '4', '8', '.'},
                {'2', '.', '7', '4', '9', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '7', '.', '1', '.', '.'},
                {'3', '.', '1', '5', '.', '.', '.', '7', '2'},
                {'.', '9', '.', '.', '4', '2', '3', '.', '8'},
                {'1', '.', '8', '6', '.', '.', '.', '2', '9'},
                {'.', '2', '.', '.', '1', '8', '6', '4', '.'},
                {'6', '.', '.', '3', '.', '.', '.', '1', '.'}};

        new Solution().solveSudoku(ip);
    }
}



