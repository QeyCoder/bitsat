package day48;

import template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 12/02/18.
 */
public class MarkCakeWalk {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = fastInputReader.readInt();
        }
        System.out.println(solution(input));
    }

    private static long solution(int[] input) {


        Arrays.sort(input);
        long length = 0l;

        for (int i = input.length - 1; i >= 0; i--) {
            length += input[i] * (1l << input.length - i - 1);
        }
        return length;
    }
}
