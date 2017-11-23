package day16;

import java.util.Scanner;

public class BirthDayCandle {

    static int birthdayCakeCandles(int n, int[] ar) {

        Number max = new Number(Integer.MIN_VALUE, 1);
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > max.no) {
                max.no = ar[i];
                max.count = 0;
            }
            if (ar[i] == max.no) {
                max.count++;
            }
        }
        return max.count;
    }

    static class Number {
        int no;
        int count;

        public Number(int no, int count) {
            this.no = no;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
