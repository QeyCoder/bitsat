package roundone.helper.sort;

import java.util.Arrays;

public class MergeSort {

    void sort(int[] arr, int low, int high) {
        if (low < high) {

            int mid = (high + low) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int size1 = mid - low + 1;
        int size2 = high - mid;
        int arr1[] = new int[size1];
        int arr2[] = new int[size2];


        for (int i = 0; i < size1; i++) {
            arr1[i] = arr[low + i];
        }
        for (int i = 0; i < size2; i++) {
            arr2[i] = arr[mid + i + 1];
        }

        int k = low;
        int i = 0;
        int j = 0;

        while (i < size1 && j < size2) {

            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            arr[k++] = arr1[i++];
        }
        while (j < size2) {
            arr[k++] = arr2[j++];
        }
    }

    public static void main(String args[]) {
        int[] arr = new int[]{-1, 5, 8, 2, -6, -8, 11, 5};
        new MergeSort().sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private void swap(int[] arr, int parentIndex, int i) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[i];
        arr[i] = temp;
    }
}
