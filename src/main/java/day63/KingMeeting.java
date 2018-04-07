package day63;

import template.FastInputReader;

/**
 * Created by Gaurav on 02/04/18.
 */


public class KingMeeting {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int Q = fastInputReader.readInt();

        int size = (int) 1e9;
        int[][] chess = new int[size][size];

        int[][] ip = new int[2][N];
        for (int i = 0; i < N; i++) {
            int j = fastInputReader.readInt() - 1;
            int k = fastInputReader.readInt() - 1;
            ip[i][0] = j;
            ip[i][1] = k;
        }

        for (int i = 0; i < Q; i++) {
            int j = fastInputReader.readInt() - 1;
            int k = fastInputReader.readInt() - 1;


        }
        //System.out.println(stringBuilder);
    }

    private static int solution() {
        return 0;
    }


}
