package day53;

import template.FastInputReader;

/**
 * Created by Gaurav on 18/02/18.
 */
//https://www.hackerrank.com/challenges/equal/problem
public class Equal {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int[] data = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] data) {
        //return new char[0];
        return -0;
    }
}
