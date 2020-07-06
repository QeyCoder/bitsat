package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforce698A {
//storing rest day

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        int[] data = fs.readArray(n);


        int[][] dp = new int[data.length][3];
        for (int i = 0; i < data.length; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = Integer.MAX_VALUE;
        }
        dp[0][0] = 1;
        if (data[0] == 1 || data[0] == 3) {
            dp[0][1] = 0;
        }
        if (data[0] == 2 || data[0] == 3) {
            dp[0][2] = 0;
        }


        for (int i = 1; i < data.length; i++) {

            dp[i][0] = 1 + Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            if (data[i ] == 1 || data[i ] == 3) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i-1][2]);
            }

            if (data[i ] == 2 || data[i ] == 3) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i-1][1]);
            }

        }
        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));

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



