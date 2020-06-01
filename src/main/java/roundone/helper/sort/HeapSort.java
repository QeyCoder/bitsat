package roundone.helper.sort;

import java.util.Arrays;

public class HeapSort {
    public HeapSort() {
    }

    void sort(int[] arr) {
        int n = arr.length - 1;
        for (int i = n / 2 - 1; i > 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[min]) {
            min = left;
        }
        if (right < n && arr[right] < arr[min]) {
            min = right;
        }
        if (min != i) {
            swap(arr, min, i);
            heapify(arr, n, min);
        }
    }

    private void swap(int[] arr, int parentIndex, int i) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[i];
        arr[i] = temp;
    }

    public static void main(String args[]) {
        int[] arr = new int[]{-1, 5, 8, 2, -6, -8, 11, 5};
        new HeapSort().sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
