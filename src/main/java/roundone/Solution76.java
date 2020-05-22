package roundone;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    static class Solution {
        public String minWindow(String s, String t) {


            Map<Character, Integer> frequency = new HashMap<>();
            for (char c : t.toCharArray()) {
                Integer val = frequency.get(c);
                if (val == null) {
                    frequency.put(c, 1);
                } else {
                    frequency.put(c, val + 1);
                }
            }

            int start = 0;
            int end = 0;
            int count = frequency.size();
            int max = Integer.MAX_VALUE;
            String ans = "";

            while (end < s.length()) {
                char charAt = s.charAt(end);

                if (frequency.containsKey(charAt)) {
                    Integer val = frequency.get(charAt);
                        frequency.put(charAt, --val);
                        if (val == 0) {
                            count--;
                        }
                }

                end++;

                while (count == 0) {
                    if (end - start < max) {
                        max = end - start;
                        ans = s.substring(start, end);
                    }

                    char ch = s.charAt(start);
                    if (frequency.containsKey(ch)) {
                        Integer val = frequency.get(ch);
                        frequency.put(ch, val == null ? 1 : ++val);
                        if (val > 0) {
                            count++;
                        }
                    }
                    start++;

                }


            }
            return ans;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
