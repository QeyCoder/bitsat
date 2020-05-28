package roundone;

public class Solution318 {

    class Solution {
        public int maxProduct(String[] words) {

            int[] bitStorage = new int[words.length];
            for(int i=0;i<words.length;i++){

                int ans = 0;

                for(int j=0;j< words[i].length();j++){
                    ans|=1<<words[i].charAt(j)-'a';
                }
                bitStorage[i]=ans;
            }
            int max= 0;

            for(int i=0;i<words.length;i++){
                for(int j=i+1;j< words.length;j++){
                    if ((bitStorage[i] & bitStorage[j])==0) {
                        max = Math.max(max, words[i].length()*words[j].length());
                    }
                }
            }
            return max;
        }
    }
}
