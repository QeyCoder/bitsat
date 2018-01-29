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
        int pivot = 0;
        quickSort(data, 0, pivot, data.length - 1);


    }

    private static void quickSort(int[] data, int start, int pivot, int end) {
        if (start < end) {

            pivot = partition(data,start,end);
            quickSort(data, start, pivot - 1, end);
            quickSort(data, start, pivot + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        return 0;
    }

}
