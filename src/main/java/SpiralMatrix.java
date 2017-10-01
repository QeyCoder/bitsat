/**
 * Created by Gaurav on 30/08/17.
 */
public class SpiralMatrix {


    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int rowStart = 0;
        int colStart = 0;
        int noOfRow = input.length;
        int noOfCol =  input[0].length;




        printSpiral(input,rowStart,colStart,noOfRow,noOfCol);

    }

    private static void printSpiral(int[][] input, int rowStart, int colStart, int noOfRow, int noOfCol) {
        for (int i = 0; i < rowStart; i++) {
            for (int j = 0; j < colStart; j++) {

            }


        }
    }
}
