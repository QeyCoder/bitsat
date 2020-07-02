package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforce1343B {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int cases = fs.nextInt();
        while (cases-->0){
         solve(fs.nextInt());
        }
    }

    private static void solve(int i) {

        if(i/2%2!=0){
            System.out.println("NO");
        } else{
            System.out.println("YES");
            int x=2;
            int sum1=0;
            for (int j = 0; j <i/2 ; j++) {
                System.out.print(x+" ");
                sum1+=x;
                x+=2;
            }
            x=1;
            int sum=0;
            for (int j = 0; j < i/2-1; j++) {
                System.out.print(x+" ");
                sum+=x;
                x+=2;
            }
            System.out.println(sum1-sum);

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



