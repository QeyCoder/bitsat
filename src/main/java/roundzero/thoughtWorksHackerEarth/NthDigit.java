package roundzero.thoughtWorksHackerEarth;

import java.util.Scanner;

/**
 * Created by Gaurav on 05/05/18.
 */


public class NthDigit {


    public static void main(String[] args) {

     /*NthDigit ref =  new NthDigit();
        ref.solution();
        */
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {

            long N = Long.parseLong(scanner.nextLine());
            stringBuilder.append(solution(N,3)).append("\n");
        }
        System.out.println(stringBuilder);
    }

   /* private static int solution(long n) {

        return (int) Math.ceil(Math.log(n) / Math.log(3));
*//*
        long next = 3;
        int count = 1;

        while (true) {
            if (n < next) {
                return count;
            }

            next = next * 3;
            count++;
        }*//*

    }*/

   static long solution(long num, int base) {
        long i = 0, rem, j;

        if (num == 0) {
            return 0;
        }

        while (num > 0) {

            rem = num % base;
            i++;
            num /= base;
        }

        return i;
    }


}
