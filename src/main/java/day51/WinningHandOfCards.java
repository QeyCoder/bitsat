package day51;

import template.FastInputReader;

/**
 * Created by Gaurav on 17/02/18.
 */

//check with editorial
public class WinningHandOfCards {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        int m = fastInputReader.readInt();
        int x = fastInputReader.readInt();
        int[] arr = fastInputReader.readIntArray(n);

        int[] dp = new int[m];
        int[] auxilaryArray = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int remainder = 0;
                if (dp[j] != 0) {
                    remainder = (int) (((long) j) * arr[i] % m);
                } else {
                    continue;
                }
                auxilaryArray[remainder] += dp[j];
            }
            auxilaryArray[arr[i] % m]++;
            for (int j = 0; j < m; j++) {
                dp[j] += auxilaryArray[j];
                auxilaryArray[j] = 0;
            }
        }

        System.out.println(dp[x]);
    }


}
