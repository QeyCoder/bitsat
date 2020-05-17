package roundzero.day16;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * Created by Gaurav on 18/11/17.
 */
public class TrippleRecusrssion {


    public static void main(String[] args) {

        InputReader inputReader
                = new InputReader(System.in);
        int N = inputReader.nextInt();
        int M = inputReader.nextInt();
        int K = inputReader.nextInt();

        int[][] mat = new int[N][N];
        int row = N - 1;
        int col = N - 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= row; i++) {

            for (int j = 0; j <= col; j++) {

                if (i == 0 && j == 0) {
                    mat[i][j] = M;
                } else if (i == j) {
                    mat[i][j] = mat[i - 1][j - 1] + K;

                } else if (i > j) {
                    mat[i][j] = mat[i - 1][j] - 1;

                } else if (i < j) {
                    mat[i][j] = mat[i][j - 1] - 1;
                }
                stringBuilder.append(mat[i][j] + " ");
            }
            stringBuilder.append("\n");

        }
        System.out.println(stringBuilder);


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
