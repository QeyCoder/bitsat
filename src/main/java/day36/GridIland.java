package day36;/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

class GridIland {

    public static void main(String args[]) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split(" ");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            int[][] grid = new int[N][M];
            String[] cords = br.readLine().split(" ");

            int r1 = Integer.parseInt(cords[0]);
            int c1 = Integer.parseInt(cords[1]);
            int r2 = Integer.parseInt(cords[2]);
            int c2 = Integer.parseInt(cords[3]);

            for (int j = 0; j < N; j++) {

                String[] values = br.readLine().split(" ");
                for (int k = 0; k < values.length; k++) {
                    grid[i][k] = Integer.parseInt(values[k]);
                }

            }
            solution(grid, r1, c1, r2, c2);

        }


    }

    private static int solution(int[][] grid, int r1, int c1, int r2, int c2) {

       /* grid[r1][c1] ^ grid[r1+1][c1];
        grid[r1][c1] ^ grid[r1][c1+1];
        grid[r1][c1] ^ grid[r1+1][c1+1];
*/


        solution(grid, r1 + 1, c1, r2, c2);
        solution(grid, r1, c1 + 1, r2, c2);
        solution(grid, r1 + 1, c1 + 1, r2, c2);
return 0;
    }
}
