package day41;

import java.util.Scanner;

/**
 * Created by Gaurav on 22/01/18.
 */
public class InsertionSort {

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
        if (index == data.length ) {
            return;
        }
        for (int i = 0; i <= index; i++) {
            if (data[i] > data[index]) {
                swap(data, i, index);
            }
        }
        solution(data, index + 1);

    }


    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
