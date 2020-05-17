package day43;

import java.util.Scanner;

public class CounterGame {
    static boolean person = false;

    static String counterGame(long n) {
        if (n == 1l) {
            return person ? "Louise" : "Richard";
        }
        if (!isPowerOfTwo(n)) {
            long power = nextPowerOf2(n);
            n -= power;
        } else {
            n -= n / 2;
        }
        person = !person;
        return counterGame(n);
    }



    static long nextPowerOf2(long no) {
        long s  =1l;
        long n = 0;
        while (no != 1) {
            no >>= 1;
            n++;
        }
        return s<< n;
    }

    static boolean isPowerOfTwo(long x) {

        return (x & (x - 1)) == 0;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            String result = counterGame(n);
            person = false;
            System.out.println(result);
        }
        in.close();
    }
}
