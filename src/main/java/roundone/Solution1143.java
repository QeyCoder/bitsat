package roundone;

public class Solution1143 {

    static class Solution {
        int[][] dp ;
        public int longestCommonSubsequence(String text1, String text2) {
            dp= new int[text1.length()+1][text2.length()+1];
//            for (int[] row : dp) {
//                Arrays.fill(row, -1);
//            }
            solve(text1, text2);
            return dp[text1.length()][text2.length()];
        }

        private void solve(String text1, String text2) {

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if(text1.charAt(i-1)== text2.charAt(j-1)){
                        dp[i][j]= 1+ dp[i-1][j-1];
                    }else{
                        dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }

        private int solveMemo(String text1, int x, String text2, int y){
            if(x<0|| y<0){
                return 0;
            }

            if(dp[x][y]!=-1){
                return  dp[x][y];
            }
            if(text1.charAt(x)== text2.charAt(y)){
                dp[x][y]= 1+ solveMemo(text1, x-1, text2, y-1);
            }else{

                dp[x][y]= Math.max(solveMemo(text1, x-1, text2, y), solveMemo(text1, x, text2, y-1));
            }

            return  dp[x][y];

        }
    }

    public static void main(String[] args) {
        new Solution().longestCommonSubsequence("abcde","ace");
    }
}
