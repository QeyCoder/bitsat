package roundone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            //TODO use slidiing window and reset when size is equal to map size of anagram


            Map<Character, Integer> hashMap = new HashMap<>();
            for (char ch : p.toCharArray()) {

                Integer val = hashMap.get(ch);
                if (val == null) {
                    val = 0;
                }
                hashMap.put(ch, ++val);
            }


            int start = 0;
            int end = 0;
            int counter = hashMap.size();

            List<Integer> ans = new ArrayList<>();
            if(s.length()==0 || s.length()<p.length()){
                return ans;
            }
            while (end < s.length()) {
                char ch = s.charAt(end);
                if (hashMap.containsKey(ch)) {
                    Integer val = hashMap.get(ch);
                    if (val != null) {
                        hashMap.put(ch, --val);
                    }
                    if (val == 0) {
                        counter--;
                    }
                }
                end++;
                while (counter == 0) {
                    if (end - start == p.length()) {
                        ans.add(start);
                    }
                    ch = s.charAt(start);
                    if (hashMap.containsKey(ch)) {
                        Integer val = hashMap.get(ch);
                        if (val != null) {
                            hashMap.put(ch, ++val);
                        }
                        if (val > 0) {
                            counter++;
                        }
                    }
                    start++;

                }
            }
            return ans;
        }
    }
}
