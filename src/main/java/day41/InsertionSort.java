package day41;

import java.util.Scanner;

/**
 * Created by Gaurav on 22/01/18.
 */
public class InsertionSort {
    private static void solution(int[] arr, int index) {

        for (int i = 1; i <index; i++) {
            int j = i;

            while(j>0){
                if( arr[j]<arr[j-1]){
                    swap(arr,j,j-1);}
                j--;
            }
            for (int s : arr) {
                System.out.print(s + " ");

            }
            System.out.print("\n");

        }


    }


    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        solution(arr,n);
        in.close();
    }
}
