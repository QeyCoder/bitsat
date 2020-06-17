package roundone;

public class Solution1043 {

    static class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {

            int max = findMax(A, 0, K);
            A[0] = max;
            int i = 1;
            int j = i + 1;

            while (j < A.length-1+K) {
                max=A[i];
                if (A[j] > max) {
                    max = A[j];
                }
                A[i] = max;
                i++;
                j++;
            }
            int sum = 0;
            for (int x : A) {
                System.out.println(x);
                sum += x;
            }

            return sum;


        }

        private int findMax(int[] arr, int lowBound, int upBound) {


            int max = arr[lowBound];

            for (int i = lowBound + 1; i < upBound; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;

        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3);
    }
}
