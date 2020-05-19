package roundone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1222 {

    public List<List<Integer>> queensAttacktheKing1(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            boolean canAttack = getSolution(queens, king, i);
            if (canAttack) {
                List<Integer> solvedList = new ArrayList<>();
                solvedList.add(queens[i][0]);
                solvedList.add(queens[i][1]);
                ans.add(solvedList);
            }
        }
        return ans;
    }

    boolean getSolution(int[][] queens, int[] king, int currentQueen) {
        int[][] board = new int[8][8];
        ;
        for (int i = 0; i < queens.length; i++) {
            if (i != currentQueen) {
                board[queens[i][0]][queens[i][1]] = 1;
            }
        }

        return solve(board, king[0], king[1], queens[currentQueen][0], queens[currentQueen][1]);


    }


    boolean solve(int[][] board, int kingX, int kingY, int x, int y) {
        if (x < 0 || x == 8 || y < 0 || y == 8) {
            return false;
        }
        if (kingX == x && kingY == y) {
            return true;
        }
        if (board[x][y] != 0) {
            return false;
        }
        board[x][y] = 1;
        if (kingX == x && kingY != y) {
            boolean ans = solve(board, kingX, kingY, x, y + 1);
            if (revertAns(board, x, y, ans)) return true;
            ans = solve(board, kingX, kingY, x, y - 1);
            if (revertAns(board, x, y, ans)) return true;
        } else if (kingY == y && kingX != x) {
            boolean ans = solve(board, kingX, kingY, x + 1, y);
            if (revertAns(board, x, y, ans)) return true;
            ans = solve(board, kingX, kingY, x - 1, y);
            if (revertAns(board, x, y, ans)) return true;
        } else if (kingX + kingY == x + y) {
            boolean ans = solve(board, kingX, kingY, x - 1, y + 1);
            if (revertAns(board, x, y, ans)) return true;
            ans = solve(board, kingX, kingY, x + 1, y - 1);
            if (revertAns(board, x, y, ans)) return true;
        } else if (kingX - kingY == x - y) {
            boolean ans = solve(board, kingX, kingY, x - 1, y - 1);
            if (revertAns(board, x, y, ans)) return true;
            ans = solve(board, kingX, kingY, x + 1, y + 1);
            if (revertAns(board, x, y, ans)) return true;
        }
        board[x][y] = 0;
        return false;

    }


    private boolean revertAns(int[][] board, int x, int y, boolean ans) {
        if (!ans) {
            board[x][y] = 0;
        } else {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        new Solution1222()
                .queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0});
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] chess = new boolean[8][8];

        for (int[] queen : queens) {
            chess[queen[0]][queen[1]] = true;
        }
        int[] direction = new int[]{-1, 0, 1};
        for (int x : direction) {
            for (int y : direction) {
                if (x == 0 && y == 0) continue;

                int X = king[0], Y = king[1];
                while (X + x >= 0 && X + x < 8 && Y + y >= 0 && Y + y < 8) {
                    X+= x;
                    Y += y;
                    if (chess[X][Y]) {
                        ans.add(Arrays.asList(X, Y));
                        break;
                    }
                }


            }

        }
        return ans;
    }
}
