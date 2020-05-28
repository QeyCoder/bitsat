package roundone;

public class Solution204 {
    class Solution {
        public int countPrimes(int n) {
            int ans=0;
            for(int i=2;i<n;i++){
                if(prime(i)){
                    ans++;
                }
            }
            return ans;

        }
        private boolean prime(int n){

            for(int i=2; i*i<=n;i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
    }
}
