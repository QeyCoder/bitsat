package day69;

import template.FastInputReader;

/**
 * Created by Gaurav on 22/04/18.
 */


public class SubSetAnd {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            stringBuilder.append(solution(null)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static long solution(int[] set) {

        long total = 0;

        for (int bit = 1; bit != 0; bit <<= 1) {

            int setBit = 0;
            for (int i : set) {
                if ((i & bit) != 0) setBit++;
            }

            long subsets = (1L << setBit) - 1;
            total += (bit * subsets) % (int) (1e9 + 7);
        }

        return total;
    }


}
