package day123;

public class Solution1 {
    public int solution(int[] input) {
        int n = input.length;
        int maxDiff;
        int i, j;

        int rightMax[] = new int[n];
        int leftMin[] = new int[n];

        leftMin[0] = input[0];
        for (i = 1; i < n; ++i) {
            leftMin[i] = Math.min(input[i], leftMin[i - 1]);
        }
        rightMax[n - 1] = input[n - 1];
        for (j = n - 2; j >= 0; --j) {
            rightMax[j] = Math.max(input[j], rightMax[j + 1]);
        }
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (leftMin[i] != rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        Solution1 solution
                 =  new Solution1();
        int[] jn = {4, 6, 2, 2, 6, 6, 4};
        solution.solution(jn);
    }
}

