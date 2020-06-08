package roundone;

public class Solution231 {

    static class Solution {
        public boolean isPowerOfTwo(int x) {
            return (x != 0) && (x & (x - 1)) == 0;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
