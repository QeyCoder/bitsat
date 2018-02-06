package projectEuler;

import template.FastInputReader;

/**
 * Created by Gaurav on 05/02/18.
 */
public class Problem6 {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader(System.in);
        int cases = fastInputReader.readInt();
        StringBuilder stringBuilder
                = new StringBuilder();
        for (int i = 0; i < cases; i++) {
            int N = fastInputReader.readInt();

            long output = sumOfNumberSquare(N) - sumOfSquareNumber(N);
            stringBuilder = stringBuilder.append(output).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static long sumOfNumberSquare(long n) {

        long sum = n * (n + 1) / 2;
        return sum * sum;

    }

    private static long sumOfSquareNumber(long n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }
}

