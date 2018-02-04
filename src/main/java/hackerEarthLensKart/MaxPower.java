package hackerEarthLensKart;

import template.FastInputReader;

/**
 * Created by Gaurav on 03/02/18.
 */
public class MaxPower {


    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader(System.in);
        int cases = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < cases; i++) {
            int N = fastInputReader.readInt();
            int[] ints = new int[N];
            for (int j = 0; j < N; j++) {
                ints[j] = fastInputReader.readInt();
            }
            stringBuilder.append(solution(ints)).append("\n");

        }
        System.out.println(stringBuilder);

    }

    private static int solution(int[] ints) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
            if (ints[i] < min) {
                min = ints[i];
            }

        }
        return max - min;
    }
}
