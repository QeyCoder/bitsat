package day48;

import template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 13/02/18.
 */
public class MaxPerimiterTriangle {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();

        int[] sticks = new int[n];
        for (int i = 0; i < n; i++) {
            sticks[i] = fastInputReader.readInt();
        }

        solution(sticks);
    }

    private static void solution(int[] sticks) {
        Arrays.sort(sticks);
        int i = sticks.length - 1;
//sort the array
        //start from the last 3 elements if matches continue till we break the base condition means reaches the 1st  3 elements and if i>=2 print element else -1
        while (i >= 2 && (sticks[i - 2] + sticks[i - 1] <= sticks[i]))
            i--;
        if (i >= 2) {
            System.out.println(sticks[i - 2] + "," + sticks[i - 1] + "," + sticks[i]);
        } else {
            System.out.println(-1);
        }

    }
}
