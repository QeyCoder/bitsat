package day63;

/**
 * Created by Gaurav on 03/04/18.
 */


public class MinimumJump {


    public static void main(String[] args) {
        int[] input = {1, 4, 3, 7, 1, 2, 6, 7, 6, 10};


        System.out.println(solution(input, 0, input.length - 1));
    }

    private static int solution(int[] input, int start, int target) {
        int[] dp = new int[input.length];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }


        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j] + j >= dp[i]) {
                    if (dp[i] + 1 < dp[j]) {
                        dp[j] = dp[j] + 1;
                    }
                }
            }
        }
        return dp[input.length - 1];
    }

    private static int recusrive(int[] input, int start, int target) {

        if (start == target) {
            return 0;
        }
        if (input[start] == 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        /**
         *          i <= start + input[start];
         *
         *          jumping from current should not cross end of the array
         **/

        for (int i = start + 1; i <= target && i <= start + input[start]; i++) {
            int jump = recusrive(input, i, target);
            if (jump != Integer.MAX_VALUE && jump + 1 < min) {
                min = jump + 1;
            }

        }
        return min;
    }


}
