package day63;


import roundzero.template.FastInputReader;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Gaurav on 02/04/18.
 */


public class BuildBridge {


    private static Comparator<? super Pair> comp = new BridgeComparator();

    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        Pair[] north = new Pair[T];
        Pair[] south = new Pair[T];
        for (int i = 0; i < T; i++) {
            north[i] = new Pair(fastInputReader.readInt(), fastInputReader.readInt());
        }
        for (int i = 0; i < T; i++) {
            south[i] = new Pair(fastInputReader.readInt(), fastInputReader.readInt());
        }

        Arrays.sort(north, comp);
        Arrays.sort(south, comp);
        Pair[] pairs = new Pair[T];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            pairs[i] = new Pair(north[i].j, south[i].j);

        }
        int x =595455545;


        Arrays.sort(pairs, comp);
        System.out.println(solution(pairs, pairs.length));
    }

    private static int solution(Pair[] pairs, int length) {


        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }


        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j].j <= pairs[i].j && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }

            }
        }
        int max = -1;
        for (int i = 0; i < length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }


    private static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static class BridgeComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.i == o2.i) {
                return o1.j - o2.j;
            } else {
                return o1.i - o2.i;
            }
        }

    }


}
