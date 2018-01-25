package day41;

import java.util.Scanner;

/**
 * Created by Gaurav on 22/01/18.
 */
public class SelectionSort {


    public static void main(String[] args) {

        Scanner scanner
                = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] ip = scanner.nextLine().split(" ");
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = Integer.parseInt(ip[i]);
        }


        solution(data, 0);
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    private static void solution(int[] data, int index) {
        if (index == data.length - 1) {
            return;
        }
        int min = index;


        for (int i = index + 1; i < data.length; i++) {

            if (data[min] > data[i]) {
                min = i;
            }

        }
        swapWithOutTemp(data, min, index);
        solution(data, index + 1);
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void swapWithOutTemp(int[] data, int i, int j) {
        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];

    }

    //iterative
    static void selection_sort(int A[], int n) {
        // temporary variable to store the position of minimum element

        int minimum;
        // reduces the effective size of the array by one in  each iteration.

        for (int i = 0; i < n - 1; i++) {

            // assuming first element to be minimum of the  unsorted array .
            minimum = i;

            // gives the effective size of unsorted  array .

            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minimum]) {                //finds the minimum element
                    minimum = j;
                }
            }
            // putting minimum element on its proper position.
            swap(A, minimum, i);
        }
    }
}
