package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution278 {

    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */
    static class VersionControl {
        boolean isBadVersion(int x) {
            return x == 4;

        }
    }

    static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int i = 1;
            int j = n;
            return solve(i, j);

        }

        private int solve(int i, int j) {
            if (i == j) {
                return i;
            }
            int mid = i + (j - i) / 2;
            if (isBadVersion(mid)) {
                return solve(i, mid );
            } else {
                return solve(mid + 1, j);
            }


        }

        public static void main(String[] args) {
            new Solution().firstBadVersion(5);
        }
    }
}



