package day48;

import template.FastInputReader;

/**
 * Created by Gaurav on 13/02/18.
 */
public class BeautifulPair {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int[] A = new int[N];
        int[] B = new int[N];


        for (int i = 0; i < N; i++) {
            A[i] = fastInputReader.readInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = fastInputReader.readInt();
        }
    }
}
