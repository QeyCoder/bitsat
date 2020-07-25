package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 1;

            int i = 0;
            int j = 1;


            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            while (i <= j && j < s.length()) {
                if(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }else{
                    set.add(s.charAt(j));
                    j++;
                }
                max = Math.max(max, set.size());

            }
            return max;
        }
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("pwwkew");
    }
}



