package day16;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
 * Created by Gaurav on 17/11/17.
 */
//https://www.hackerearth.com/challenge/hiring/credit-suisse-full-stack-developer-hiring-challenge/problems/13fc151f49a3407a843ab74daa447e9f/
public class Combination {

    static BigInteger two = new BigInteger("2");

    public static void main(String[] args) {


        InputReader inputReader = new InputReader(System.in);
        int N = inputReader.nextInt();
        BigInteger mod = new BigInteger("1000000007");

        for (int i = 0; i < N; i++) {


            int ppl = inputReader.nextInt();
            BigInteger op = two.pow(ppl);
            System.out.println(op.subtract(two).mod(mod).intValue());
        }


    }

    static BigInteger powerTwo(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else if (y.mod(two) == BigInteger.ZERO)
            return powerTwo(x, y.divide(two)).multiply(powerTwo(x, y.divide(two)));
        else
            return x.multiply(powerTwo(x, y.divide(two))).multiply(powerTwo(x, y.divide(two)));
    }

    BigInteger power(BigInteger x, BigInteger y) {
        BigInteger temp;
        if (y.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        temp = power(x, y.divide(two));
        if (y.mod(two).equals(BigInteger.ZERO)) {
            return temp.multiply(temp);
        } else {
            if (y.compareTo(BigInteger.ZERO) == 1)
                return x.multiply(temp).multiply(temp);
            else
                return temp.multiply(temp).divide(x);
        }
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
