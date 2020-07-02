package interviewBit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PowerOfInteger {

    public static class Solution {
        public int isPower(int A) {
            if (A == 1) {
                return 1;
            }
            for (int i = 2; i * i <= A; i++) {
                double x = Math.log(A) / Math.log(i);
                if ((float) x == (int) x) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        new Solution().isPower(4);
    }


}



