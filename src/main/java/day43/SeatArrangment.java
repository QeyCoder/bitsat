package day43;

import template.FastInputReader;

/**
 * Created by Gaurav on 01/02/18.
 */
public class SeatArrangment {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader(System.in);

        int n = fastInputReader.readInt();
        int m = fastInputReader.readInt();
        int k = fastInputReader.readInt();
        boolean[][] mater = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = fastInputReader.readString();
            for (int j = 0; j < m; j++) {
                mater[i][j] = str.charAt(j) == '.' ? true : false;
            }
        }
        System.out.println(solution(mater, n, m, k));
    }

    private static int solution(boolean[][] mater, int row, int col, int k) {
        int ans = 0;
        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = 0; j < col; j++) {


                if (mater[i][j]) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= k) {
                    ans++;
                }
            }

        }

        if (k > 1) {
            for (int i = 0; i < col; i++) {
                int count = 0;
                for (int j = 0; j < row; j++) {

                    if (mater[j][i]) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count >= k) {
                        ans++;
                    }
                }

            }
        }
        return ans;

    }

}
