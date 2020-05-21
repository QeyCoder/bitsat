package roundone;

import java.util.Arrays;

public class Solution1004 {

    static class Solution {

        int max = 0;
        int start = 0;

        public int longestOnes(int[] A, int K) {
            int localMax = 0;
            for (int i = 0; i < A.length; i++) {

                if (A[i] == 1) {
                    localMax++;
                } else {
                    if (i > 0) {
                        if (A[i - 1] == 1) {
                            if (localMax > max) {
                                max = localMax;
                                start = i - localMax;
                                localMax = 0;
                            }
                        }
                    }
                }
            }
            int end = start + max;
            start = start - 1;
            boolean s = true;
            boolean e = true;
            while (start > 0 && end < A.length && K >= 0) {
                if (!s || !e) {
                    break;
                }
                if (K > 0 && A[start] == 0 && s) {
                    A[start] = 1;
                    start--;
                    K--;
                    max++;
                } else {
                    s = !s;
                }
                if (K > 0 && A[end] == 0 && e) {
                    A[end] = 1;
                    end++;
                    K--;
                    max++;
                } else {
                    e = !e;
                }
            }
            if (K == 0) {
                start--;
                end++;
                while (start > 0 && end < A.length) {

                    if (A[start] == 1) {
                        start--;
                        max++;
                    }
                    if (A[end++] == 1) {
                        end++;
                        max++;
                    }

                }
            }
            return max;

        }
    }


    public static void main(String[] args) {
        Solution solution
                = new Solution();
        System.out.println(solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, 2));
    }
//TODO incomplete