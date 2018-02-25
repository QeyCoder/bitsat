package day56;

import template.FastInputReader;

/**
 * Created by Gaurav on 24/02/18.
 */


public class CubesAndCylinder {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        int m = fastInputReader.readInt();

        int[] S = fastInputReader.readIntArray(n);
        int[] K = fastInputReader.readIntArray(n);
        int[] R = fastInputReader.readIntArray(m);
        int[] C = fastInputReader.readIntArray(m);


        solution(S, K, R, C);
    }

    private static void solution(int[] s, int[] k, int[] r, int[] c) {

    }


}
