package day14;

/**
 * Created by Gaurav on 17/10/17.
 */
public class RotateImage {

    public static void main(String[] args) {

        int[][] image = {{33, 35, 8, 24, 19, 1, 3, 1, 4, 5},
                {25, 27, 40, 25, 17, 35, 20, 3, 19, 3},
                {9, 1, 9, 30, 9, 25, 32, 12, 15, 22},
                {30, 47, 25, 10, 18, 1, 19, 17, 43, 17},
                {40, 46, 42, 34, 18, 48, 29, 40, 31, 39},
                {37, 42, 37, 19, 45, 1, 4, 46, 48, 13},
                {8, 26, 31, 46, 44, 24, 34, 29, 12, 25},
                {45, 48, 36, 12, 33, 12, 4, 45, 22, 37},
                {33, 15, 34, 25, 34, 8, 50, 48, 30, 28},
                {18, 19, 22, 29, 15, 43, 38, 30, 8, 47}};

        rotateImage(image);
    }

    private static int[][] rotateImage(int[][] image) {

        int n = image.length;
        int[][] extra = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "," + j);
                System.out.println(j + "," + (n - i - 1) + "\n");
                extra[j][n - i - 1] = image[i][j];
            }
        }


        return extra;
    }


}
