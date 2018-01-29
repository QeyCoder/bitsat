package day42;

import java.util.Scanner;

public class InsertionSort1 {

    private static void solution(int[] arr, int index) {

        for (int i = index-1 ; i >= 0; i--) {
            int j = i;

            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    for (int s : arr) {
                        System.out.print(s + " ");

                    }
                    System.out.print("\n");
                    arr[j-1] = temp;

                }
                j--;
            }


        }
        for (int s : arr) {
            System.out.print(s + " ");

        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        solution(arr, n);
        in.close();
    }
}
