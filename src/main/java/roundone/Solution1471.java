package roundone;

import java.util.Arrays;

public class Solution1471 {

    static class Solution {

        class Helper {
            int x;
            int w;

            public Helper(int x, int w) {
                this.x = x;
                this.w = w;
            }
        }

        public int[] getStrongest(int[] arr, int k) {
            Arrays.sort(arr);
            int median = 0;
            int len = arr.length;
            median = arr[len-1 / 2];


            Helper[] ans = new Helper[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int diff = median - arr[i];
                ans[i] = new Helper(arr[i], diff > 0 ? diff : -diff);
            }
            Arrays.sort(ans, (o1, o2) -> {

                if (o1.w == o2.w) {
                    return o2.x - o1.x;
                }
                return o2.w - o1.w;
            });

            int[] finalAns = new int[k];

            for (int i = 0; i < k; i++) {
                finalAns[i] = ans[i].x;
            }
            return finalAns;

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.getStrongest(new int[]{1,2,3,4,5}, 2);
    }
}
