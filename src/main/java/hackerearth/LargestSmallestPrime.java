package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargestSmallestPrime {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] arr = fs.readArray(n);
        solve(arr);
    }

    private static void solve(int[] arr) {

        Arrays.sort(arr);


        int i = 0;
        int j = arr.length - 1;

        int small = findPrime(arr, 0);
        int large = findPrimeL(arr, j);
        System.out.println(large - small);
    }

    private static int findPrime(int[] arr, int i) {

        for (int j = 0; j < arr.length; j++) {

            if(isPrime(Math.abs(arr[j]))){
                return arr[j];
            }

        }
        return -1;
    }

    private static int findPrimeL(int[] arr, int i) {

        for (int j = i; j >=0; j--) {

            if(isPrime(Math.abs(arr[j]))){
                return arr[j];
            }

        }
        return -1;
    }


    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
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



