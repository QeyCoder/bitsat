package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution125 {

    static class Solution {
        public boolean isPalindrome(String s) {


            int i = 0;
            int j = s.length() - 1;


            while (i < j) {

                char iCh = s.charAt(i);
                char jCh = s.charAt(j);

                if (!isValidChar(iCh)) {
                    i++;
                    continue;
                }
                if (!isValidChar(jCh)) {
                    j--;
                    continue;
                }

                if (Character.toLowerCase(jCh) != Character.toLowerCase(iCh)) {
                    return false;
                }
                i++;
                j--;

            }
            return true;
        }

        private boolean isValidChar(char ch) {

            if(ch>=48 && ch<=57 || ch>=65 && ch<=90 || ch>=97 && ch<=122 ){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }
}



