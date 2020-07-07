package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZoolAndTeacher {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
            int  cases =  fs.nextInt();
            while (cases-->0){
                int n = fs.nextInt();
                int b =fs.nextInt();
                int g =  fs.nextInt();
                System.out.println(solve(b,g));
            }
    }

    private static String solve(int b, int g) {

        return Math.abs(b-g)>2? "Little Jhool wins!":"The teacher wins!";
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



