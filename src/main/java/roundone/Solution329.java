package roundone;

public class Solution329 {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length()==0){
                return true;
            }

            if(s.length()>t.length()){
                return false;
            }
            return check(s, t, s.length()-1, t.length()-1);
        }

        private boolean check(String s, String t, int m, int n){
            if(m<0||n< 0){
                return false;
            }
            if(m==0){
                if(s.charAt(m)== t.charAt(n)){
                    return true;
                }
            }


            if(s.charAt(m)== t.charAt(n)){
                return check(s,t,m-1, n-1);
            }
            return check(s,t, m,n-1);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
