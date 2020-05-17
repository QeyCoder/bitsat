package roundzero.day57;

import roundzero.template.FastInputReader;
import roundzero.template.MiscUtils;

/**
 * Created by Gaurav on 25/02/18.
 */


public class MinCostPath {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int[][] data = fastInputReader.readTable(N, N);


            stringBuilder.append(solution(data, 0, 0)).append("\n");


        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[][] data, int i, int j) {
        for (int k = 0; k < j; k++) {



            if (i > data.length - 1 || k > data.length - 1) {
                return Integer.MIN_VALUE;
            } else if (i == data.length - 1 && k == data.length - 1) {
                return data[i][j];
            } else {

                return data[i][k] + MiscUtils.max(MiscUtils.max(solution(data, i, k + 1), solution(data, i + 1, k)), solution(data, i + 1, k + 1));
            }
        }

        return 0;
    }


}
