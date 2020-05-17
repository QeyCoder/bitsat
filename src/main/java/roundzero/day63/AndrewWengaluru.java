package day63;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 05/04/18.
 */


public class AndrewWengaluru {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int[] data = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static long solution(int[] data) {


        int[] left = new int[data.length];
        int[] right = new int[data.length];

        int max = data[0];
        left[0] = max;
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];

            }
            left[i] = max;
        }

        max = data[data.length - 1];
        right[data.length - 1] = max;
        for (int i = data.length - 2; i >= 0; i--) {
            if (data[i] > max) {
                max = left[i];

            }
            right[i] = max;
        }

        long total = 0;
        for (int i = 0; i < data.length; i++) {
            int trap = FastInputReader.MiscUtils.min(left[i], right[i]) - data[i];
            if (trap > 0) {
                total += trap % (1e9 + 7);

            }

            total %= (1e9 + 7);
        }

        return (long) (total % (1e9 + 7));
    }


}
