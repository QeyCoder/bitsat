package day41;

import java.util.Scanner;

/**
 * Created by Gaurav on 22/01/18.
 */
public class BubbleSort {
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

        for (int i = 0; i < data.length; i++) {
            for (int j = i+1; j <data.length ; j++) {
                if(data[i]>data[j]){
                 swap(data,i,j);
                }
                
            }
        }

    }
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
