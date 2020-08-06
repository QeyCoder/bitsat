package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1399A {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        while (n-- > 0) {
            int size = fs.nextInt();
            int[] ip = fs.readArray(size);
            Arrays.sort(ip);
            String ans = "YES";
            for (int i = 1; i < ip.length; i++) {
                if (ip[i] - ip[i - 1] > 1) {
                    ans = "NO";
                    break;
                }

            }
            System.out.println(ans);
        }
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



