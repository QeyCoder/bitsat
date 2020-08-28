package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution550A {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), i = fs.nextInt();


        int[] ip = fs.readArray(n-1);
        int j = 0;
        while (j < ip.length) {
            if (j == i-1) {
                System.out.println("YES");
                return;
            }
            int tmp = ip[j];
            j += tmp;


        }
        if(j==i-1){
            System.out.println("YES");
        }else{

            System.out.println("NO");
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



