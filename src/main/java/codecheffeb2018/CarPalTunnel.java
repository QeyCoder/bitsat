package codecheffeb2018;

import template.FastInputReader;

/**
 * Created by Gaurav on 02/02/18.
 */
public class CarPalTunnel {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader(System.in);

        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = fastInputReader.readInt();

            int[] data = new int[N];
            for (int j = 0; j < N; j++) {
                data[j] = fastInputReader.readInt();
            }
            int C = fastInputReader.readInt();
            int D = fastInputReader.readInt();
            int S = fastInputReader.readInt();
            //stringBuilder = stringBuilder.append(solution(data));
        }
        System.out.println(stringBuilder.toString());
    }
}
