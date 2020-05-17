package roundzero.day16;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * Created by Gaurav on 16/11/17.
 */
public class LuckyPurchase {

    public static void main(String[] args) {


        InputReader inputReader
                = new InputReader(System.in);

        int noOfCase = inputReader.nextInt();
        String[] laptopModel = new String[noOfCase];
        String[] laptopPrice = new String[noOfCase];
        for (int i = 0; i < noOfCase; i++) {
            laptopModel[i] = inputReader.readString();
            laptopPrice[i] = inputReader.readString();
        }

        System.out.println(solution(laptopModel, laptopPrice));

    }

    private static String solution(String[] laptopModel, String[] laptopPrice) {


        int luckyIndex = 0;

        for (int i = 0; i < laptopPrice.length; i++) {
            String price = laptopPrice[i];
            int four = 0;
            int seven = 0;
            for (int j = 0; j < price.length(); j++) {
                if (price.charAt(j) == 7 + 48) {
                    seven++;
                }
                if (price.charAt(j) == 4 + 48) {
                    four++;
                }
            }

            if (four > 0 && seven > 0 && four == seven) {
                if (luckyIndex != 0) {
                    if (Integer.parseInt(laptopPrice[i]) < Integer.parseInt(laptopPrice[luckyIndex])) {
                        luckyIndex = i;
                    }

                } else {
                    luckyIndex = i;
                }
            }


        }
        if (luckyIndex == -1) {
            return "-1";
        }
        return laptopModel[luckyIndex];


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
