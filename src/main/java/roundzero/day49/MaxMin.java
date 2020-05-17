package roundzero.day49;

import roundzero.template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 14/02/18.
 */
public class MaxMin {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader();
        int N = fastInputReader.readInt();
        int K = fastInputReader.readInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = fastInputReader.readInt();
        }
        System.out.println(solution(data, K));
    }

    private static int solution(int[] data, int k) {
        Arrays.sort(data);
        int diff = Integer.MAX_VALUE;
        for (int i = k-1; i < data.length; i++) {
            int temp = data[i] - data[i - k+1];
            if (temp < diff) {
                diff = temp;
            }
        }
        return diff;
    }
}
