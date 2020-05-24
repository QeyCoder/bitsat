package roundone;

public class Solution5417 {
    static class Solution {
        public int maxVowels(String s, int k) {
            if(s.length()==0){
                return 0;
            }
            if(k>s.length()){
                k=s.length();
            }

            int i = 0;
            int j = 0;
            int max = 0;
            int vowel = 0;
            while (j - i != k && j < s.length()) {

                char ip = s.charAt(j);
                if (ip == 'a' || ip == 'e' || ip == 'i' || ip == 'o' || ip == 'u') {
                    vowel++;
                }
                j++;
                if (j - i == k) {
                    if (vowel > max) {
                        max = vowel;
                    }
                }
                while (j - i == k) {
                    ip = s.charAt(i);
                    if (ip == 'a' || ip == 'e' || ip == 'i' || ip == 'o' || ip == 'u') {
                        vowel--;
                    }
                    i++;


                }
            }
            return max;
        }
    }


    public static void main(String[] args) {
        Solution solution
                = new Solution();
        System.out.println(solution.maxVowels("abciiidef", 13));
    }
}