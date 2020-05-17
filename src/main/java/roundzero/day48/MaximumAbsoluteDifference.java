package roundzero.day48;

import roundzero.template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 12/02/18.
 */
public class MaximumAbsoluteDifference {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();

        int n = fastInputReader.readInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fastInputReader.readInt();
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < 0) {
                diff = -diff;
            }
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }
}
