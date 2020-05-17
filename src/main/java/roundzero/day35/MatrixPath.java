package day35;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 19/12/17.
 */
public class MatrixPath {
    static  class C1{

}

    static class C2 extends  C1{

    }
    public static void main(String[] args) {
        List<String >  strings =  new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add(1,"c");
        C2 c2
                =  new C2();
        C1 h = (C1) c2;
    }

    public static void maisn(String[] args) {

        int[][] a = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 9}};
        System.out.println("--");
        solution(a, 0, 0, new String());
        System.out.println("--");
    }

    private static void solution(int[][] matrix, int row, int column, String path) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        if (row == rowCount - 1) {
            for (int k = column; k < colCount; k++) {
                path = path + "-" + matrix[row][k];
            }
            System.out.println(path);
            return;

        }


        if (column == colCount - 1) {
            // if col = max col-1;
            for (int k = row; k < rowCount; k++) {
                path = path + "-" + matrix[k][column];
            }
            System.out.println(path);
            return;
        }
        path = path + "-" + matrix[row][column];
        solution(matrix, row + 1, column, path);
        solution(matrix, row, column + 1, path);
    }
}
