package day55;

import template.FastInputReader;
import template.MiscUtils;

/**
 * Created by Gaurav on 22/02/18.
 */
public class KadaneAlgo {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int[] data = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static int solution(int[] data) {

        int startIndex = 0;
        int endIndex = 0;
        int maxSoFar = data[0];
        int current = data[0];

        for (int i = 1; i < data.length; i++) {

            current = MiscUtils.max(data[i], data[i] + current);
            maxSoFar = MiscUtils.max(current, maxSoFar);
        }
        return maxSoFar;
    }
}
