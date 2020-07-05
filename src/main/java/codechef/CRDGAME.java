package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CRDGAME {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int cases = fs.nextInt();
        while (cases-- > 0) {

            int roundPlayed = fs.nextInt();
            long chefR = 0;
            long mortyR = 0;
            while (roundPlayed-- > 0) {
                int x = getSum(fs.nextInt());
                int y = getSum(fs.nextInt());

                if (x > y) {
                    chefR++;
                } else if (x < y) {
                    mortyR++;
                }else{
                    chefR++;
                    mortyR++;
                }
            }
            if (chefR > mortyR) {
                System.out.println("0 " + chefR);
            } else if (chefR < mortyR) {
                System.out.println("1 " + mortyR);
            } else {
                System.out.println("2 " + chefR);
            }

        }
    }

    private static int getSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
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



