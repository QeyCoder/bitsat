package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Solution1399B {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        while (n-- > 0) {
            int readTotal = fs.nextInt();
            int[] a = fs.readArray(readTotal);
            int[] b = fs.readArray(readTotal);
            int aMin = Arrays.stream(a).min().getAsInt();
            int bMin = Arrays.stream(b).min().getAsInt();
            long tot = 0;

            for (int i = 0; i < a.length; i++) {

                if (a[i] != aMin && b[i] != bMin) {
                    tot += Math.max(a[i]-aMin, b[i]-bMin);
                } else {
                    tot += a[i] - aMin;
                    tot += b[i] - bMin;
                }
            }
            System.out.println(tot);
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



