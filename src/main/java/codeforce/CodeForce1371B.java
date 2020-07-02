package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeForce1371B {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int cases = fs.nextInt();
        while (cases-- > 0) {
            long n = fs.nextLong(), m = fs.nextLong();
            m = Math.min(n, m);
            long ans = m * (m - 1) / 2;
            if (m == n) {
                ans += 1;
            } else {
                ans += m;
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



