package roundzero.tataHealth;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 22/04/18.
 */


public class MaximumArraySum {


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
        int length = data.length - 1;
        quickSort(data, 0, length);
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        sum /= 2;

        int K = data[0];
        int dif = Integer.MAX_VALUE;
        for (int i = 1; i < data.length; i++) {
            if (data[i] - K < dif) {
                dif = data[i] - K;
                K  =  data[i];
            }
        }


        for (int i = 0; i < data.length; i++) {
            if (data[i] < K) {
                sum -= data[i];
            } else {
                sum += K;
            }
        }
        return sum;

    }

    private static void quickSort(int[] data, int start, int end) {
        if (start < end) {
            int pivot = partition(data, start, end);
            quickSort(data, start, pivot - 1);
            quickSort(data, pivot + 1, end);
        }
    }

    private static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] aArr, int start, int end) {
        int temp = aArr[start];
        aArr[start] = aArr[end];
        aArr[end] = temp;
    }


}
