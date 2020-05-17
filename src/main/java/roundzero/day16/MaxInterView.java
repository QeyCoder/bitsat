package roundzero.day16;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * Created by Gaurav on 11/11/17.
 */
//https://www.hackerearth.com/challenge/competitive/she-codes-indeed/algorithm/k-chocolates-selection-64ccd8cf/
public class MaxInterView {
    static int[][] matrix;

    public static void main(String[] args) {


        InputReader inputReader = new InputReader(System.in);
        int k = inputReader.nextInt();
        int n = inputReader.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = inputReader.nextInt();
        }
        matrix = new int[n][n];
        //System.out.println(solution(k, ints, 0, ints.length - 1));
        System.out.println(solution1(k, ints));


    }

    private static int solution1(int k, int[] ints) {
        int row = ints.length;
        int col = k + 1;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            dp[i][0] = 0;
        }
        dp[0][1] = ints[0];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (i+1 == j ) {
                    dp[i][j] = dp[i - 1][j - 1] + ints[i];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j-1] + ints[i], dp[i - 1][j]);
                }
            }
        }
        return dp[ints.length - 1][k];
    }

    private static int solution(int k, int[] ints, int i, int j) {
        if (k == 1) {
            if (i == j) {
                return ints[i];
            }
            return Math.max(ints[i], ints[j]);
        } else {
            if (matrix[i][j] != 0) {
                return matrix[i][j];
            }
            int left = 0;
            int right = 0;
            left = ints[i] + solution(k - 1, ints, i + 1, j);
            right = ints[j] + solution(k - 1, ints, i, j - 1);
            matrix[i][j] = Math.max(left, right);

        }
        return matrix[i][j];
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
