package day35;

import java.util.Scanner;

///https://www.hackerrank.com/contests/world-codesprint-12/challenges/breaking-sticks
public class BreakingChoclate {

    static long longestSequence(long[] a) {
        int count = 0;
        for (long temp : a) {

            count += solution(temp);

        }
        return count;

    }

    static long solution(long data) {
        if (data == 1) {
            return 1;
        }
        if (data % 2 == 0) {
            long temp = data / 2;
            if(temp==3) {
                return 3 * (solution(data / 3) + 1);
            }
            return (data / 2) * (solution(data / 2) + 1);

        } else {
            return (data / 2) * (solution(data / 2) + 1)+1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }
}
