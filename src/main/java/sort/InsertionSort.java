package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InsertionSort {


    private  void sort(int [] no){

        for (int i = 0; i <no.length ; i++) {
            int element=  no[i];
            int j = i;

            while(j>0 && element< no[j-1]){
                no[j]=  no[j-1];
                j--;
            }
                no[j]= element;

        }

        for (int i = 0; i < no.length; i++) {
            System.out.print(no);
            System.out.print(" ");

        }
    }



    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int size = fs.nextInt();
        new InsertionSort().sort(fs.readArray(size));

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



