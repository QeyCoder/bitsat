package day41;

import java.util.Scanner;

/**
 * Created by Gaurav on 25/01/18.
 */
public class QuickSort {

    public static void main(String[] args) {

        Scanner scanner
                = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] ip = scanner.nextLine().split(" ");
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = Integer.parseInt(ip[i]);
        }


        solution(data);
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    private static void solution(int[] data) {


        //taking start as pivot
        quickSort(data, 0, data.length - 1);


    }

    private static void quickSort(int[] data, int start, int end) {
        if (start < end) {
            int pivot = partition(data, start, end);
            quickSort(data, start, pivot - 1);
            quickSort(data, pivot + 1, end);
        }
    }

    private static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] aArr, int start, int end) {
        int temp = aArr[start];
        aArr[start] = aArr[end];
        aArr[end] = temp;
    }

}
