package day36;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/sum-vs-xor/problem
public class XORSUM {

    static double solve(long n) {
        if(n==0){
            return 0;
        }
        long count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                count++;
            }
            n /= 2;
        }
        return  Math.pow(2,count);
    }

    public static void maisn(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = (long) solve(n);
        System.out.println(result);
    }

    public static void main(String[] args) {
        int n=3;
        int count = 0;
        while (n!=0){
            n &=n-1;
            count++;
        }
        System.out.println(count);
    }
}
