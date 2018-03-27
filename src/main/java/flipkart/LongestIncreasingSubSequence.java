package flipkart;

import template.FastInputReader;

/**
 * Created by Gaurav on 21/03/18.
 */


public class LongestIncreasingSubSequence {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int[] ip = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(ip)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] ip) {

        int[] dp = new int[ip.length];
        int[] solut = new int[ip.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < ip.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ip[i] > ip[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    solut[i] = j;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > dp[max]) {
                max = i;
            }
        }
        for (int i = 0; i < solut.length - 1; i++) {
            if (solut[i] + 1 == solut[i + 1])
                System.out.println(ip[solut[i]]);
        }


        return dp[max];
    }


}
