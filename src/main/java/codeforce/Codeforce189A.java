package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforce189A {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), a = fs.nextInt(), b = fs.nextInt(), c = fs.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(solve(dp, n, a, b, c, 1));
    }

    private static int solve(int[] dp, int n, int a, int b, int c, int i) {

        if (i > n + 1) {
            return Integer.MIN_VALUE;
        }

        if (i == n + 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        return dp[i] = Math.max(Math.max(solve(dp, n, a, b, c, i + a), solve(dp, n, a, b, c, i + b)), solve(dp, n, a, b, c, i + c))+1;


    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }
}



