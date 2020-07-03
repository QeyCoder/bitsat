package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class CodeForce768A {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] ip = fs.readArray(n);
        int mx = Arrays.stream(ip).max().getAsInt();
        int mn = Arrays.stream(ip).min().getAsInt();
//        System.out.println(Arrays.stream(ip).filter(value -> value != mn && value != mx).distinct().count());
        int c1=0;
        int c2=0;
        for (int i = 0; i < n; i++) {
            if (ip[i] == mx) c1++;
            if (ip[i] == mn) c2++;
        }
        if (mx == mn) System.out.println(0);
        else System.out.println(n - c1 - c2);
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



