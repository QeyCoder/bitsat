package roundone;

public class Solution520 {


    public static void main(String[] args) {
        new Solution().detectCapitalUse("FlaG");
    }

    static class Solution {
        public boolean detectCapitalUse(String s) {
            return isUpper(s) || isLower(s) || isStartWithCap(s);
        }


        boolean isUpper(String word) {


            int i = 0;
            while (i < word.length()) {
                if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {

                } else {
                    return false;
                }
                i++;
            }
            return true;
        }

        boolean isLower(String word) {

            int i = 0;
            while (i < word.length()) {
                if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {

                } else {
                    return false;
                }
                i++;
            }
            return true;
        }

        boolean isStartWithCap(String s) {

            return isUpper(s.substring(0, 1)) && isLower(s.substring(1, s.length() ));
        }
    }
}



