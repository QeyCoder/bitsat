package roundone;

import java.util.Arrays;

public class SOlution583 {

    class Solution {
        //memoize
        public int minDistance(String word1, String word2) {

            int[][] dp = new int[word1.length()+1][word2.length()+1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return solution(word1,word2,word1.length(),word2.length(), dp);

        }
        private int solution(String word1, String word2, int i, int j,int[][] dp) {


            if(i==0){
                return j;

            }
            if(j==0){
                return i;
            }
            if(dp[i-1][j-1]!=-1){
                return dp[i-1][j-1];
            }
            if(word1.charAt(i-1)== word2.charAt(j-1)){
                return dp[i-1][j-1] =  solution(word1,word2,i-1,j-1,dp);
            }

            return dp[i-1][j-1] =min(solution(word1,word2,i,j-1,dp)+1,solution(word1,word2,i-1,j,dp)+1);

        }

        private int min(int a, int b) {
            return Math.min(a, b);
        }
    }
}
