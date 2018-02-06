package projectEuler;

import template.FastInputReader;

/**
 * Created by Gaurav on 06/02/18.
 */
public class Problem16 {

    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader(System.in);
        int cases = fastInputReader.readInt();
        StringBuilder stringBuilder
                = new StringBuilder();

        for (int i = 0; i < cases; i++) {
            int N = fastInputReader.readInt();


            int len = (int) (Math.floor(N / Math.log(10)) + 1);

            int[] arr = new int[len + 1];
            //set base;

            arr[len-1] = 2;

            int carry = 0;
            int range = 1;
            int index = 0;
            while (index != N-1) {
                for (int k = range; k > 0; k--) {
                    index++;
                    int data = arr[k] * 2 + carry;
                    carry = data / 10;
                    data %= 10;
                    arr[k] = data;
                }

            }



            stringBuilder.append(solution(arr)).append("\n");

        }
        System.out.println(stringBuilder.toString());

    }

    private static long solution(int[] ans) {
        long sum = 0l;
        for (int i = 0; i < ans.length; i++) {
            sum += ans[i];
        }
        return sum;
    }
}
