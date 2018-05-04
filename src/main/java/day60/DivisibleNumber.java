package day60;

import template.FastInputReader;

/**
 * Created by Gaurav on 05/03/18.
 */


public class DivisibleNumber {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            stringBuilder.append(solution(N)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i <= n / 2; i++) {
            if (i % n == 0 && i % 10 != 0 && getMultiple(i)) {
                return i;
            }
        }
        return 0;
    }

    static class Pair {
        int mul;
        int sum;
    }

    private static boolean getMultiple(int n) {

        int mul = 1;
        int sum = 0;
        while (n != 0) {
            mul *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return sum >= mul;
    }


}
