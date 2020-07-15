package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution383 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {


            Map<Character, Integer> map = new HashMap<>();



            for(int i=0; i< magazine.length();i++){

                map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0)+1);
            }
            for(int i=0; i< ransomNote.length();i++){
                if(!map.containsKey(ransomNote.charAt(i))){
                    return false;
                }
                Integer val = map.get(ransomNote.charAt(i));
                if(val==1){
                    map.remove(ransomNote.charAt(i));
                }else{
                    map.put(ransomNote.charAt(i), val-1);
                }

            }
            return true;

        }
    }
}



