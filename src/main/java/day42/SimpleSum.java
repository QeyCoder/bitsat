package day42;

import java.util.Scanner;

public class SimpleSum {

    static int simplestSum(int k, int a, int b) {
        int max = Math.max(a, b);
        long[][] memo = new long[max + 1][max + 1];
        int sum = 0;
        for (int i = a; i <= b; i++) {
            if (memo[k][i] == 0) {
                memo[k][i] = fun(k, i);
            }
            sum += memo[k][i];
        }
        return sum;
    }

    private static long fun(int k, int n) {

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            i *= k;
        }
        return sum % 1000000007;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int k = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int result = simplestSum(k, a, b);
            System.out.println(result);
        }
        in.close();
    }
}
