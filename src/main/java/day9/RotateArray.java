package day9;

/**
 * Created by Gaurav on 07/10/17.
 */
public class RotateArray {

    int[] rotateArray(int array[], int no) {

        int i = 0;
        while (no >= 0) {
            int m = 0, n = 0;
            swap(array, m, n);
        }
        return array;
    }

    private void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;

    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] op = rotateArray.rotateArray(new int[]{1, 2, 3, 4, 5, 6}, 1);
        System.out.printf("Magic");

    }
}
