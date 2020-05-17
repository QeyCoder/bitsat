package day63;

import java.util.HashMap;

/**
 * Created by Gaurav on 07/04/18.
 */


public class LongestSubString {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {


        int i = 0;
        int j = 0;
        HashMap<Character, Integer> characterSet = new HashMap<>();
        int max = 0;
        while (i < s.length() && j < s.length()) {
            char ip = s.charAt(j);
            Integer op = characterSet.get(ip);
            if (op != null) {
                i = Math.max(op,i);
            }
            characterSet.put(ip, j + 1);
            if (max < j - i + 1) {
                max = j - i + 1;
            }
            j++;


        }
        return max;
    }

}
