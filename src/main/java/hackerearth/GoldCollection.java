package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldCollection {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int r = fs.nextInt(), c = fs.nextInt();

        int[][] mat = new int[r][c];


        for (int i = 0; i < r; i++) {
            mat[i] = fs.readArray(c);
        }

        int q = fs.nextInt();
        while (q-- > 0) {
            int x1 = fs.nextInt() - 1, y1 = fs.nextInt() - 1, x2 = fs.nextInt() - 1, y2 = fs.nextInt() - 1;

            long sum = 0;
            for (int i = x1; i <=x2; i++) {

                for (int j = y1; j <= y2; j++) {
                    sum += mat[i][j];

                }

            }
            System.out.println(sum);
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



