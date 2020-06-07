package roundone;

public class Solution1137 {

    static class Solution {
        public int tribonacci(int n) {
            if(n==0){
                return 0;
            }
            if(n==1|| n==2){
                return 1;
            }
            int T0=0;
            int T1=1;
            int T2=1;
            int ans=0;
            for(int i=3;i< n;i++){
                ans =T2+T1+T0;
                T0=T1;
                T1=T2;
                T2= ans;

            }
            return T2+T1+T0;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
