package roundone;

import java.util.ArrayList;
import java.util.List;

public class Solution279 {
    static class Solution {
        List<Integer> store ;
        public int numSquares(int n) {

            int i=1;
            store = new ArrayList<>();
            while(i*i<n){
                store.add(i*i);
                i++;
            }
            return solve(n);
        }


        private int solve(int n){

            if(n<0){
                return Integer.MAX_VALUE;
            }
            if(n==0){
                return 1;
            }
            int way=Integer.MAX_VALUE;
            for(int i=0; i< store.size();i++){
                way=Math.min(way, solve(n-store.get(i)))+1;
            }
            return way;
        }
    }
    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.numSquares(12);
    }
}
