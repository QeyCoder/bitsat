package roundone;

public class Solution1314 {
    static class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] ans = new int[m][n];


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int I1 = i - K;
                    int I2 = i + K;
                    int J1 = j - K;
                    int J2 = j + K;

                    if(check(I1,m)&& check(J1,n)){
                        ans[I1][J1] = ans[I1][J1]+mat[I1][J1]+mat[i][j];
                    }

                    if(check(I1,m)&& check(J2,n)){
                        ans[I1][J2] = ans[I1][J2]+mat[I1][J2]+mat[i][j];
                    }

                    if(check(I2,m)&& check(J2,n)){
                        ans[I2][J2] =ans[I2][J2]+ mat[I2][J2]+mat[i][j];
                    }

                    if(check(I2,m)&& check(J1,n)){
                        ans[I2][J1] =ans[I2][J1]+ mat[I2][J1]+mat[i][j];
                    }


                }
            }
            return ans;
        }
        boolean check(int x, int m) {
            return x >= 0 && x < m;
        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.matrixBlockSum(new int[][]{{1, 2}}, 1);
    }
}
