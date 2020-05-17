package roundzero.day16;

/**
 * Created by Gaurav on 31/10/17.
 */
public class MatrixPath {


    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3},
                {3, 4, 3},
                {4, 5, 3}

        };

        int row = input.length;
        int column = input[0].length;
        System.out.println(finaAllPath(row, column));
        System.out.println(findPathDevide(row, column));


    }

    //CloudDay with recursion
    private static int findPathDevide(int row, int column) {
        if (row == 1 || column == 1) {
            return 1;
        }

       return  findPathDevide(row-1,column)+ finaAllPath(row,column-1);

    }


    //CloudDay with Dp
    private static int finaAllPath(int row, int column) {
        if (row == 1 || column == 1) {
            return 1;
        }

        int[][] temp = new int[row][column];


        for (int i = 0; i < row; i++) {
            temp[i][0] = 1;
        }

        for (int i = 0; i < column; i++) {
            temp[0][i] = 1;
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }

        return temp[row - 1][column - 1];
    }
}
