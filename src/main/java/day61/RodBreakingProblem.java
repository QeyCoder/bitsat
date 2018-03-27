package day61;

import template.FastInputReader;

/**
 * Created by Gaurav on 07/03/18.
 */


public class RodBreakingProblem {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int K = fastInputReader.readInt();
            int[] len = fastInputReader.readIntArray(N);
            int[] pro = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(len, pro, K, N - 1)).append("\n");
            stringBuilder.append(cutRod(pro,N));
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] len, int[] pro, int k, int index) {
        if (k == 0) {
            return 0;
        }
        if (index < 0) {
            return 0;
        }

        int max = -1;
        // System.out.println(index);
        for (int i = 0; i <= index; i++) {
            if (k - len[i] >= 0) {
                max = FastInputReader.MiscUtils.max(max, pro[i] + solution(len, pro, k - len[i], index - i - 1));
            }
           // System.out.println(max);
        }

        return max;
    }
    static int cutRod(int price[], int n)
    {
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;

        // Recursively cut the rod in different pieces and
        // compare different configurations
        for (int i = 0; i<n; i++)
            max_val = Math.max(max_val,
                    price[i] + cutRod(price, n-i-1));

        return max_val;
    }


}
