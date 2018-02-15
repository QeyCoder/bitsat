package day50;

import template.FastInputReader;

/**
 * Created by Gaurav on 15/02/18.
 */
public class PrimeGenerator {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int testCases = fastInputReader.readInt();
        for (int i = 0; i < testCases; i++) {
            int m = fastInputReader.readInt();
            int n = fastInputReader.readInt();

            for (int j = m; j <=n; j++) {
                if (j == 1) {
                    continue;
                }
                if (j == 2) {
                    System.out.println(j);
                } else {
                    if (j % 2 != 0) {
                        if (isPrime(j)) {
                            System.out.println(j);
                            j++;
                        }

                    }
                }
            }
        }
    }

    private static boolean isPrime(int j) {

        for (int i = 3; i * i <= j; i = i + 2) {
            if (j % i == 0)
                return false;
        }
        return true;
    }
}
