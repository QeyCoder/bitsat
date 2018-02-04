package day44;

import template.FastInputReader;

/**
 * Created by Gaurav on 01/02/18.
 */
public class NaratuAndJastu {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader(System.in);
        int T = fastInputReader.readInt();

        for (int i = 0; i < T; i++) {
            int N = fastInputReader.readInt();
            System.out.println(solution(N));

        }
    }

    private static long solution(int n) {

        long sum = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i != i) {
                    if ((n / i % 2) != 0) {
                        sum = sum + (n / i);
                    }
                    if ((i % 2) != 0) {
                        sum = sum + i;
                    }
                } else {
                    if ((i % 2) != 0) {
                        sum = sum + i;
                    }
                }

            }

        }
        return sum;


    }
}
