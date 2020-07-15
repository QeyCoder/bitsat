package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution151 {
    static class Solution {
        public String reverseWords(String s) {
            String[] ip = s.split(" ");
            StringBuilder op = new StringBuilder();

            for(int i= ip.length-1; i>=0;i--){
                op.append(ip[i].trim()).append(" ");
            }
            return op.toString().trim();

        }

        public static void main(String[] args) {
            new Solution().reverseWords("a good   example");
        }
    }
}



