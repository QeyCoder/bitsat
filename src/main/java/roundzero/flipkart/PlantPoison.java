package roundzero.flipkart;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 16/03/18.
 */


public class PlantPoison {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();

            int[] ip = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(ip)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] ip) {

        boolean find = false;


        return 0;
    }


}
