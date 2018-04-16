package day67;

/**
 * Created by Gaurav on 11/04/18.
 */


public class MinimumDistance {


    public static void main(String[] args) {
        int x = 1146963504;
        System.out.println();
    }

    public int minDistance(String A, String B) {
        return solve(A.toCharArray(), B.toCharArray(), A.length(), B.length());
    }

    int solve(char[] A, char[] B, int i, int j) {
        if (A.length == 0) {
            return j;
        }
        if (B.length == 0) {
            return i;
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        int min = Integer.MAX_VALUE;
        if (A[i - 1] == B[j - 1]) {
            min = Math.min(min, solve(A, B, i - 1, j - 1));
        } else
            min = 1 + Math.min(Math.min(Math.min(min, solve(A, B, i - 1, j - 1)), solve(A, B, i - 1, j)), solve(A, B, i, j - 1));
        return min;

    }

}
