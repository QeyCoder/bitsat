package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution771 {

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int ans =0;

            Map<Character, Integer> map = new HashMap<>();



            for(int i=0; i< J.length();i++){

                map.put(J.charAt(i), map.getOrDefault(i,0)+1);
            }
            for(int i=0; i< S.length();i++){
                if(map.containsKey(S.charAt(i))){
                    ans++;
                }
            }
            return ans;
        }
    }
}



