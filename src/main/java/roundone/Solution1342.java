package roundone;

public class Solution1342 {
    static class Solution {
        public int numberOfSteps1(int n) {
            int count = 0;
            while (n != 0) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n -= 1;
                }
                count++;
            }
            return count;
        }

        public int numberOfSteps(int n) {
            return Integer.bitCount(n) + (31 - Integer.numberOfLeadingZeros(n));
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
