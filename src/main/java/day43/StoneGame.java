package day43;

import template.FastInputReader;

/**
 * Created by Gaurav on 31/01/18.
 */
public class StoneGame {
    private static int MODe = 1000000007;

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader(System.in);
        int n = fastInputReader.readInt();
        int[] stone = new int[n];
        for (int i = 0; i < n; i++) {
            stone[i] = fastInputReader.readInt();
        }
        System.out.println(solution(stone));
    }

    private static int solution(int[] stone) {
        return 0;
    }
}
