package day16;

import java.util.Scanner;

public class BirdMigration {

    static int migratoryBirds(int n, int[] ar) {
        int[] mig = new int[5];


        for (int i = 0; i < ar.length; i++) {
            mig[ar[i] - 1]++;
        }

        int max = 0;
        int index = 0;
        for (int i = mig.length-1
             ; i > 0; i--) {
            if (mig[i] >= max) {
                max = mig[i];
                index = i + 1;
            }

        }

        return index;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
