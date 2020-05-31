package roundone;

import java.util.HashSet;
import java.util.Set;

public class Solution1461 {
    static class Solution {
        public boolean hasAllCodes(String s, int k) {
            Set<String> set = new HashSet<>();

            for (int i = 0; i <=s.length() - k; i++) {
                set.add(s.substring(i, i + k));
            }

            return set.size() == 1 << k;
        }
    }

    public static void main(String[] args) {
        new Solution().hasAllCodes("0000000001011100",4);
    }
}