package day46;

import java.util.Scanner;

public class CutTheStick {

    static String cutTheSticks(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }
        }
        boolean breakT = true;
        while (breakT) {
            int index = 0;
            int newMin = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    index++;
                } else {


                    int newVal = arr[i] - min;
                    if (newVal < newMin) {
                        newMin = newVal;
                    }
                    arr[i] = newVal;
                }
            }
            stringBuilder = stringBuilder.append(index).append("\n");

            if (min == newMin) {
                breakT = false;
            }
            min = newMin;

        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }


        System.out.println( cutTheSticks(arr));


        in.close();
    }
}
