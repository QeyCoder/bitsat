package roundzero.day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 02/11/17.
 */
public class BigSUm {

    static long aVeryBigSum(int n, long[] ar) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
        sum+=ar[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(n, ar);
        System.out.println(result);
    }
}
