package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution91 {
    public static void main(String[] args) {
        new Solution().numDecodings("0");
    }


    static class Solution {
        public int numDecodings(String s) {
            int dp[] = new int[s.length()+1];
            dp[0] = 1;
            dp[1] =  s.charAt(0) == '0' ? 0 : 1;
            for (int i = 1; i < s.length(); i++) {
                Integer frst = Integer.valueOf(s.substring(i - 1, i));
                Integer scnd = Integer.valueOf(s.substring(i - 2, i));
                if (frst >= 1 && frst < 10) {
                    dp[i] += dp[i - 1];
                }

                if (scnd >= 10 && scnd < 27) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[s.length()];
        }
    }
}


