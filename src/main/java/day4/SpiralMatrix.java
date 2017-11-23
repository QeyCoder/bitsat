package day4;

/**
 * Created by Gaurav on 02/10/17.
 */
public class SpiralMatrix {
    /**
     * dir->
     * case 0: right
     * case 1: bottom
     * case 2: left
     * case 3: up
     *
     * @param A
     * @return
     */
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] spiralOrder(final int[][] A) {
        if (A.length == 1 && A[0].length == 1) {
            return new int[]{1};
        }

        int top = 0;
        int bottom = A.length - 1;
        int left = 0;
        int right = A[0].length - 1;
        int dir = 0;
        int[] finalArray = new int[A.length * A[0].length];
        int count = 0;

        while (top <= bottom && left <= right) {

            if (left <= right) {
                for (int i = left; i <= right; i++) {
                    finalArray[count++] = A[top][i];

                }
                top++;
            }
            if (top <bottom) {
                for (int i = top; i <= bottom; i++) {
                    finalArray[count++] = A[i][right];

                }

                right--;
            }
            if (right >= left) {
                for (int i = right; i >= left; i--) {
                    finalArray[count++] = A[bottom][i];

                }
                bottom--;
            }
            if (bottom >= top) {
                for (int i = bottom; i >= top; i--) {
                    finalArray[count++] = A[i][left];

                }
                left++;
            }
        }

        return finalArray;

    }


    private static void arraySp(int m, int n, int[][] a) {

        int row=0;
        int col=0;

        while(row< m && col < n){
            for (int i = col; i < n; i++) {
                System.out.println(a[row][i]);
            }
            row++;

            for (int i = row; i < m ; i++) {
                System.out.println(a[i][n-1]);
            }
            n--;

            if(row<m){
                for (int i = n-1; i >= col ; i--) {
                    System.out.println(a[m-1][i]);
                }
                m--;
            }
            if(col < n){
                for (int i = m-1; i >=row ; i--) {
                    System.out.println(a[i][col]);
                }
                col++;
            }
        }

    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] data = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}};
      //  int[] data1 = spiralMatrix.spiralOrder(data);
       // for (int i = 0; i < data1.length; i++) {
         //   System.out.println(data1[i] + " ");


        //}

        spiralMatrix.arraySp(data.length-1,data[0].length-1,data);
    }
}
