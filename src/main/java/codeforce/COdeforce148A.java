package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class COdeforce148A {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        long k = fs.nextLong(), l = fs.nextLong(), m = fs.nextLong(), n = fs.nextLong(), d = fs.nextLong();
        long c = d;
        for (int i = 0; i <= d; i++) {
            if (i % k != 0 && i % l != 0 && i % m != 0 && i % n != 0) {
                c--;
            }
        }
        System.out.println(c);

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



