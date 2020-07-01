package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution441 {

    static class Solution {
        public int arrangeCoins(int n) {

            long s=0;
            long i=0;
            while(s<=n){
                s = (i*i+i)/2;
                i++;
            }
            return (int) (i-2);

        }
    }

    public static void main(String[] args) {
        new Solution().arrangeCoins(1804289383);
    }
}



