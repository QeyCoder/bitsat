package roundzero.day66;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gaurav on 10/04/18.
 */

//https://leetcode.com/problems/surrounded-regions/description/
public class SuroundRegion {


    public static void main(String[] args) {
        SuroundRegion suroundRegion = new SuroundRegion();
        suroundRegion.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});

        System.out.println("");
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {

                    board[i][j] = '-';

                    Queue<Pair> pairs = new LinkedList<>();
                    pairs.add(new Pair(i, j));


                    while (!pairs.isEmpty()) {
                        Pair pair = pairs.poll();
                        for (int k = 0; k < direction.length; k++) {
                            int x = pair.i + direction[i][0];
                            int y = pair.i + direction[i][1];
                            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                                board[x][y] = '-';
                                pairs.add(new Pair(x, y));
                            }

                        }
                    }

                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }

            }
        }

    }


}
