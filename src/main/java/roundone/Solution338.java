package roundone;

public class Solution338 {

    class Solution {
        public int[] countBits(int num) {
            int ans[] =  new int[num+1];

            ans[0]= 0;

            //TODO Intiutation
            //[Even no end with 0 so we don't need to count no of bit] so previous num;
            //Odd number to even = 1+ current;
            for(int i=1;i< ans.length;i++){
                if((i&1)==0){
                    ans[i] =ans[i>>1];
                }else{
                    ans[i] =ans[i-1]+1;
                }
            }
            return ans;
        }
    }
}
