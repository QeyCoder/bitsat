package day33;

import java.util.Scanner;

class CandiesDistribution {

    static int candies(int n, int[] arr) {


        for (int i = 0; i < arr.length; i++) {
        //
        }
        return n;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
