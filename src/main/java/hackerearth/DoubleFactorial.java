package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DoubleFactorial {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int cases = fs.nextInt();
        while (cases-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            System.out.println(solve(n,m));
        }

    }

    private static int solve(int n, int m) {

        if (n < 3) {
            return n;
        }

        double mPower =  Math.pow(10, m);
        double frst = 1;
        double second=2;
        for (int i = 3; i <=n; i++) {

            double tmp = second%mPower * i%mPower;
            frst  = second;
            second=  tmp;



        }


        n = (int) (second % mPower);

        frst = 1;
        second=2;
        if (n < 3) {
            return n;
        }
            for (int i = 3; i <=n; i++) {

                double tmp = (second%mPower * i%mPower)%mPower;
                frst  = second;
                second=  tmp;



            }
        return (int) (second % mPower);
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



