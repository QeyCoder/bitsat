package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1360E {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        while (n-- > 0) {
            int m = fs.nextInt();

            int[][] mat = new int[m][m];
            for (int i = 0; i < m; i++) {
                mat[i] = getArray(fs.next());
            }

            System.out.println(solve(mat));
        }
    }

    private static int[] getArray(String next) {
        String[] splt = next.split("");
        int[] tmp = new int[splt.length];
        for (int i = 0; i < splt.length; i++) {
            tmp[i] = Integer.parseInt(splt[i]);

        }
        return tmp;
    }

    private static String solve(int[][] mat) {

        boolean ans = true;
        int n = mat.length;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                if (mat[i][j]==1 && mat[i + 1][j]!=1 && mat[i][j + 1]!=1) {
                    ans = false;
                }
            }
        }
        return ans?"YES":"NO";
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



