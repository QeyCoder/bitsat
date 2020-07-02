package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeForce266B {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), s = fs.nextInt();

        String ip = fs.next();
        char[] arr = ip.toCharArray();
        while (s-- > 0) {
            for (int i = 0; i < n-1; i++) {
                if (arr[i] == 'B' && arr[i+1]=='G') {
                    swap(arr, i, i + 1);
                    i++;
                }
            }
        }
        System.out.println(new String(arr));
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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



