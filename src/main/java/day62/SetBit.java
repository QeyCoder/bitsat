package day62;

import template.FastInputReader;

/**
 * Created by Gaurav on 10/03/18.
 */


public class SetBit {


    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = fastInputReader.readInt();


            int cnt = totalBit(N);

            int M = N - cnt;
            boolean yes = true;
            while (cnt > 0) {

                if (M + setBit(M) == N) {
                    yes = false;
                    break;
                }
                cnt--;
                M = N - cnt;
            }
            if (yes) {
                stringBuilder.append("1").append("\n");
            } else {
                stringBuilder.append("0").append("\n");

            }


        }
        System.out.println(stringBuilder);

    }

    static int totalBit(int n) {
        int count = 0;
        while (n != 0) {
            n >>= 1;
            count++;
        }
        return count;
    }

    static int setBit(int n) {
        int i = 0;
        while (n > 0) {
            i += n & 1;
            n >>= 1;
        }
        return i;
    }
}
