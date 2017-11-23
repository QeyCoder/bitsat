package day16;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * Created by Gaurav on 18/11/17.
 */
public class HarmonicNumbers {


    public static void main(String[] args) {


        InputReader inputReader
                = new InputReader(System.in);
        int T = inputReader.nextInt();
        for (int i = 0; i < T; i++) {
            int N = inputReader.nextInt();
            int Q = inputReader.nextInt();
            int[] array = new int[N];
            for (int j = 0; j < N; j++) {
                array[j] = inputReader.nextInt();
            }


            int max = N - 1; //Index of maximum element from right side
            int min = 0;
            int[] smaller = new int[N];
            smaller[0] = -1;  // first entry will always be -1
            for (i = 1; i < N; i++) {
                if (array[i] >= array[min]) {
                    min = i;
                    smaller[i] = -1;
                } else
                    smaller[i] = min;
            }

            // Create another array that will store index of a
            // greater element on right side. If there is no greater
            // element on right side, then greater[i] will be -1.
            int[] greater = new int[N];
            greater[N - 1] = -1;  // last entry will always be -1
            for (i = N - 2; i >= 0; i--) {
                if (array[i] > array[max]) {
                    max = i;
                    greater[i] = -1;
                } else
                    greater[i] = max;
            }


            for (int j = 0; j < Q; j++) {

                int query = inputReader.nextInt();

                int pre = -1;
                int post = -1;
                for (int k = query - 1; k > 0; k--) {
                    if (smaller[k] != -1) {
                        pre = array[smaller[k]];
                        break;

                    }
                }

                for (int k = query + 1; k < array.length; k++) {
                    if (greater[k] != -1) {
                        pre = array[greater[k]];
                        break;

                    }
                }
                if (pre == -1 || post == -1) {
                    System.out.println(0);
                } else {
                    System.out.println(pre * post * array[query]);
                }


            }


        }


    }


    private static void sortWithIndex(int[] array, Map<Integer, Integer> orderTracker) {

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
