package roundzero.day70;

import roundzero.template.FastInputReader;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Gaurav on 24/04/18.
 */


public class LongestPalindromSubString implements Callable<String>{


    public static void main(String[] args) {

        LongestPalindromSubString longestPalindromSubString =  new LongestPalindromSubString();
        FutureTask<String> task = new FutureTask<>(longestPalindromSubString);

        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            String str = fastInputReader.readString();
            stringBuilder.append(solution(str)).append("\n");
        }
        System.out.println(stringBuilder);
    }



    private static int expand(String str, int i, int j) {
        int s = i, e = j;
        int n = str.length() - 1;
        while (s >= 0 && e < n && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
        }
        return e - s + 1;
    }

    /**
     * N^2 space , N^2 time solution
     *
     * @param str
     * @return
     */
    private static String solution(String str) {


        char[] charArray = str.toCharArray();
        int n = charArray.length;

        boolean[][] dp = new boolean[n + 1][n + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][i] = true;
        }
        int begining = 0, maxLength = 0;
        for (int i = 0; i < n - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                dp[i][i + 1] = true;
                begining = i;
                maxLength = 2;
            }
        }


        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                int k = j + i - 1;
                //    System.out.println("i:" + i + " j:" + j + " k:" + k);
                if (charArray[j] == charArray[k] && dp[j + 1][k - 1]) {
                    dp[j][k] = true;
                    if (k > maxLength) {
                        begining = j;
                        maxLength = k;
                    }
                }
            }

        }

        /*for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(" " + (dp[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }*/

        return str.substring(begining, maxLength + 1);
    }


    @Override
    public String call() throws Exception {
        return null;
    }
}
