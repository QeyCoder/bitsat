package day48;

import template.FastInputReader;

/**
 * Created by Gaurav on 12/02/18.
 */
public class LuckBalance {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int K = fastInputReader.readInt();

        int[] L = new int[N];
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = fastInputReader.readInt();
            T[i] = fastInputReader.readInt();
        }

        solution(L,T);
    }

    private static void solution(int[] l, int[] t) {

    }
}
