package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFSTR1 {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();

        int cases = fs.nextInt();
        while (cases-->0){
            int size = fs.nextInt();
            int [] arr =  fs.readArray(size);
            System.out.println(solve(arr));
        }
    }

    private static long  solve(int[] arr) {
        long ans = 0;
        for (int i = 1; i < arr.length; i++) {
            ans+= Math.abs(arr[i]-arr[i-1])-1;
        }
        return  ans;
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



