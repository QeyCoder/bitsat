package day63;

public class MaxSky {

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));;
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];

        for (int i = 0; i < row.length; i++) {
            row[i] = -1;
        }
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {

                int element = grid[i][j];
                if (element > row[i]) {
                    row[i] = element;
                }
                if (element > col[j]) {
                    col[j] = element;
                }

            }

        }


        int total =0;

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {

                int current = grid[i][j];
                int min = min(row[i], col[j]);

                if(min< current){
                    //ignore
                }else {
                    total+= min-current;
                }


            }
        }
        return total;
    }

    private static int min(int i, int j) {

        return i > j ? j : i;

    }
}