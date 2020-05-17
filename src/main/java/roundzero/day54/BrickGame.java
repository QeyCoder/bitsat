package roundzero.day54;

import roundzero.template.FastInputReader;
import roundzero.template.MiscUtils;

/**
 * Created by Gaurav on 20/02/18.
 */
public class BrickGame {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader();
        int cases = fastInputReader.readInt();

        StringBuilder stringBuilder
                = new StringBuilder();
        for (int i = 0; i < cases; i++) {
            int N = fastInputReader.readInt();
            int[] stack = new int[N];
            for (int j = N; j > 0; j--) {
                stack[j - 1] = fastInputReader.readInt();
            }
            stringBuilder.append(solution(stack, N)).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static int solution(int[] stack, int n) {


        int[] sum = new int[n];
        sum[0] = stack[0];
        for (int i = 1; i < stack.length; i++) {
            sum[i] = sum[i - 1] + stack[i];
        }

        int[] dp = new int[n];

        dp[0] = sum[0];
        dp[1] = sum[1];
        dp[2] = sum[2];

        for (int i = 3; i < n; i++) {
            //including 3 brick
            dp[i] = sum[i] - dp[i - 3];
            dp[i] = MiscUtils.max(dp[i], sum[i] - dp[i - 2]);
            dp[i] = MiscUtils.max(dp[i], sum[i] - dp[i - 1]);

        }
        return dp[n - 1];

    }


}
