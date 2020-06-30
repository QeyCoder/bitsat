package roundone;

public class Solution1492 {
    static class Solution {
        public int kthFactor(int n, int k) {
            boolean[] no = new boolean[n+1];
            for (int i = 1; i <= (n+1) / 2; i++) {
                if (n % i == 0) {
                    no[i] = no[(n / i)] = true;
                }
            }
            for (int i = 0; i < no.length; i++) {
                if (no[i]) {
                    k--;
                }
                if (0 == k) {
                    return i;
                }

            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthFactor(1,1));
    }
}
