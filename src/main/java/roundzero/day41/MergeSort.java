package roundzero.day41;

import java.util.Scanner;

/**
 * Created by Gaurav on 23/01/18.
 */
public class MergeSort {


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
        mergeSort(data, 0, data.length - 1);
    }

    private static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }


    }

    private static void merge(int[] data, int start, int mid, int end) {

        int size1 = mid - start + 1;
        int size2 = end - mid;


        int[] a = new int[size1];
        int[] b = new int[size2];




        for (int i = 0; i < size1; ++i) {
            a[i] = data[start + i];
        }
        for (int j = 0; j < size2; ++j) {
            b[j] = data[mid + j + 1];
        }



        int k = start;
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (a[i] <= b[j]) {
                data[k] = a[i];
                i++;
            } else {
                data[k] = b[j];
                j++;
            }
            k++;
        }


        while (i < size1) {
            data[k] = a[i];
            i++;
            k++;
        }
        while (j < size2) {
            data[k] = b[j];
            j++;
            k++;
        }
    }


}
