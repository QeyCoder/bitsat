package codecheffeb2018;

import template.FastInputReader;

/**
 * Created by Gaurav on 02/02/18.
 */
public class ChedAndPatents {


    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader(System.in);


        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = fastInputReader.readInt();
            int M = fastInputReader.readInt();
            int X = fastInputReader.readInt();
            int K = fastInputReader.readInt();
            String S = fastInputReader.readString();

            stringBuilder.append(solution(S, N, M, X, K));
        }
        System.out.println(stringBuilder.toString());
    }

    private static String solution(String S, int N, int M, int X, int K) {

        return null;
    }
}
