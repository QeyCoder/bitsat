package day16;

import java.util.Arrays;
import java.util.Scanner;

public class maxMin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        printMaxMin(arr);
    }

    private static void printMaxMin(int[] arr) {
        Arrays.sort(arr);

        long max = 0;
        long min = 0;
        for (int i = 1; i < 5; i++) {
            max += arr[i];
        }
        for (int i = 0; i < 4; i++) {
            min += arr[i];
        }
        System.out.println(min+" "+max);


    }
}
