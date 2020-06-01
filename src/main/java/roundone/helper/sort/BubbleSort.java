package roundone.helper.sort;

import java.util.Arrays;

public class BubbleSort {

    void sort(int[] arr) {


        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }

            }

        }
    }

    public static void main(String args[]) {
        int[] arr = new int[]{-1, 5, 8, 2, -6, -8, 11, 5};
        new BubbleSort().sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private void swap(int[] arr, int parentIndex, int i) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[i];
        arr[i] = temp;
    }
}
