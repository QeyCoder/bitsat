package day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 22/11/17.
 */
public class BirthDayAndGift {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();


            //min(b*x + w*y,
        }
    }


    static long min(long a, long b) {


        return a > b ? a : b;

    }
}
