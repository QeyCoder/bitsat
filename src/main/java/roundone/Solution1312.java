package roundone;

public class Solution1312 {

    class Solution {
        public int minInsertions(String s) {
            return finMin(s, 0, s.length() - 1);
        }


        public int finMin(String s, int start, int end) {


            if (start > end) {
                return Integer.MAX_VALUE;
            }

            if (start == end) {
                return 0;
            }

            if (start == end - 1) {
                return s.charAt(start) == s.charAt(end) ? 0 : 1;
            }
            if (s.charAt(start) == s.charAt(end)) {
                return finMin(s, start + 1, end - 1);

            }
            return Math.min(finMin(s, start + 1, end), finMin(s, start, end - 1));
        }

        boolean isPalindrom(String s) {
            int start = 0;
            int end = s.length() - 1;

            while (start <= end) {

                if (s.charAt(start++) != s.charAt(end--)) {
                    return false;
                }

            }
            return true;
        }
    }
}
