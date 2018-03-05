package day59;

import template.MiscUtils;

/**
 * Created by Gaurav on 05/03/18.
 */


public class RemoveElement {


    public static void main(String[] args) {

        int arr[] = {2, 4, 4, 6, 8, 6, 1};
        int k = 2;

        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        int op = solution(dp, arr, 0, arr.length - 1, k);
        System.out.println(op);
    }

    private static int solution(int[][] dp, int[] arr, int start, int end, int k) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (end - start + 1 < 3) {
            return end - start + 1;
        }

        //not picking up the element
        int op = 1 + solution(dp, arr, start + 1, end, k);


        for (int i = start + 1; i <= end - 1; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (arr[i] - arr[start] == k && arr[j] - arr[i] == k && solution(dp, arr, start + 1, i - 1, k) == 0 && solution(dp, arr, i + 1, j - 1, k) == 0) {
                    op = MiscUtils.min(op, solution(dp, arr, j + 1, end, k));
                }
            }
        }
        dp[start][end] = op;
        return op;


    }


}
