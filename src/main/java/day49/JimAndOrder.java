package day49;

import template.FastInputReader;

/**
 * Created by Gaurav on 14/02/18.
 */
public class JimAndOrder {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        int[] t = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = fastInputReader.readInt();
            d[i] = fastInputReader.readInt();
        }

        solution(t,d);
    }

    private static void solution(int[] t, int[] d) {

    }
}
