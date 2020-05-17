package day62;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 10/03/18.
 */


public class StockBuySell {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        StringBuilder stringBuilder = new StringBuilder();

        int N = fastInputReader.readInt();
        int[] stock = fastInputReader.readIntArray(N);
        stringBuilder.append(solution(stock, N)).append("\n");
        System.out.println(stringBuilder);
    }

    private static int solution(int[] arr, int n) {
        int j = 0;
        while (arr[j] < 0) {
            j++;
        }
        j++;

        int max_diff = arr[j] - arr[j - 1];
        int min_element = arr[j - 1];
        int i;
        for (i = j; i < n; i++) {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }
}



