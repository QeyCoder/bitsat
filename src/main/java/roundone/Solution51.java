package roundone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//N queen
public class Solution51 {

    class Solution {
        public List<List<String>> solveNQueens(int n) {


            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');

            }

            List<List<String>> ans = new ArrayList<>();

            solve(board, ans, 0);
            return ans;

        }

        private void solve(char[][] board, List<List<String>> ans, int col) {
            if (col == board.length) {
                ans.add(construct(board));
                return;
            }

            for (int i = 0; i < board.length; i++) {
                if (canPut(board, i, col)) {
                    board[i][col] = 'Q';
                    solve(board, ans, col + 1);
                    board[i][col] = '.';
                }
            }
        }

        private List<String> construct(char[][] board) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                ans.add(new String(board[i]));

            }
            return ans;


        }

        private boolean canPut(char[][] board, int row, int col) {


            for (int j = 0; j < board.length; j++) {
                if (board[row][j] == 'Q') {
                    return false;
                }
            }


            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
}



