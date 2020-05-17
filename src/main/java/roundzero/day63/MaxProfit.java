package day63;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 02/04/18.
 */


public class MaxProfit {


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
        int[][] mem = new int[ip.length][3];
        for (int i = 0; i < ip.length; i++) {
            mem[i][0] = ip[i];
        }
        int max = 0;
        for (int i = 0; i < ip.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ip[i] > ip[j]) {
                    for (int l = 0; l < 3 - 1; l++) {
                        if (mem[j][l] != 0 && ip[i] * mem[j][l] > mem[i][l + 1]) {
                            mem[i][l + 1] = ip[i] * mem[j][l];
                        }
                    }
                }
            }
            if (mem[i][3 - 1] > max) max = mem[i][3 - 1];
        }
        return max == 0 ? -1 : max;
    }

}
