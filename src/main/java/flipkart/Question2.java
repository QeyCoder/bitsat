package flipkart;

import template.FastInputReader;

/**
 * Created by Gaurav on 01/04/18.
 */


public class Question2 {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = fastInputReader.readInt();

            int[] ip = fastInputReader.readIntArray(N);
            stringBuilder.append(orSum(ip,N)).append("\n");

        }
        System.out.println(stringBuilder);
    }


    static long orSum(int arr[],int n) {

        long sum = 0;
        long powerSet = ((long)1) << n;

        for (int i = 0; i < powerSet; i++) {
            long or = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    if (j == 0) {
                        or = arr[j];
                    } else {
                        or &= arr[j];
                        or %= (1e9 + 7);
                    }
                }
            }

            sum += or;
            sum %= 1e9 + 7;
        }
        return sum;

    }

    private static int solution(int[] ip) {


        //Map<Integer, Integer>
        int sum = 0;

        for (int i = 0; i < ip.length; i++) {
            for (int j = i; j < ip.length; j++) {
                int result = ip[i];
                for (int k = i + 1; k <= j; k++) {
                    result ^= ip[k];
                }
                sum += result;
                sum %= 1e9 + 7;
            }
        }
        return sum;
    }


}
