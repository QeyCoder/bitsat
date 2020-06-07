package roundone;

public class Solution796 {

    static class Solution {
        public boolean rotateString(String A, String B) {
            return A.length()==B.length()&& (A+A).contains(B);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.rotateString("gaurav", "saurav");
    }
}
