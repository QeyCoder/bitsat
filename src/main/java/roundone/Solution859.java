package roundone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution859 {

    static class Solution {
        public boolean buddyStrings(String A, String B) {



            if(A.length()!=B.length()){
                return false;
            }

            if(A.equals(B)){
                Set<Character> set1 =  new HashSet<>();
                for(int i = 0; i< A.length();i++){
                    set1.add(A.charAt(i));
                }
                return set1.size()<A.length();
            }
            List<Integer> diff = new ArrayList<>();

            int count = 0;
            for(int i = 0; i< A.length();i++){
                if(A.charAt(i)!= B.charAt(i)){
                    diff.add(i);
                    count++;
                }
            }
            return count==2 && A.charAt(diff.get(0))==B.charAt(diff.get(1)) && B.charAt(diff.get(0))==A.charAt(diff.get(1));
        }
    }
    public static void main(String[] args) {


     System.out.println(new Solution().buddyStrings("aa","a"));
    }
}
