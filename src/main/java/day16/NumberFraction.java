package day16;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Gaurav on 02/11/17.
 */
public class NumberFraction {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solve(arr,arr.length);
    }

    private static void solve(int[] arr, int len) {

        long s =  (long)len;
        double[] precise = new double[3];

        for (int i : arr) {

            if (i > 0) {
                precise[0]++;
            }else if(i<0){
                precise[1]++;
            }else {
                precise[2]++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.000000");
        for (int i = 0; i < precise.length; i++) {
            System.out.println  (df.format(precise[i]/s));
        }



    }

}
