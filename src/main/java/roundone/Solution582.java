package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Solution582 {
    static class Solution {
        Random random;
        int total;
        int[] w;

        public Solution(int[] w) {
            random = new Random();
            total = 0;

            for (int i = 0; i < w.length; i++) {
                total += w[i];
                w[i] = total;
            }
            this.w = w;
        }

        public int pickIndex() {
            int index = random.nextInt(total) + 1;
            int l = 0;
            int r = w.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;

                if ( w[mid]< index) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */

    public static void main(String args[]) {
        Solution solution = new Solution(new int[]{1, 5, 2});
        solution.pickIndex();
        solution.pickIndex();
        solution.pickIndex();
        solution.pickIndex();
        solution.pickIndex();
        solution.pickIndex();
    }
}
