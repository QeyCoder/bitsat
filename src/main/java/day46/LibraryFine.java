

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;


/**
 * Created by Gaurav on 07/02/18.
 */
public class LibraryFine {


    static class FastInputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public FastInputReader(InputStream stream) {
            this.stream = stream;
        }

        public FastInputReader() {
            this(System.in);
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c))
                    res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    public static void main(String[] args) {


        FastInputReader fastInputReader
                = new FastInputReader();
        int d = fastInputReader.readInt();
        int m = fastInputReader.readInt();
        int y = fastInputReader.readInt();


        int d1 = fastInputReader.readInt();
        int m1 = fastInputReader.readInt();
        int y1 = fastInputReader.readInt();


        int dateDiff = d - d1;
        int monthDiff = m - m1;
        int yeaDiff = y - y1;

        if (yeaDiff > 0) {
            System.out.println(1000);
        } else if (monthDiff > 0 && yeaDiff>=0) {
            System.out.println(500 * monthDiff);
        } else if(dateDiff > 0 && monthDiff >= 0 && yeaDiff>=0) {
            System.out.println(15 * dateDiff);
        }else{
            System.out.println(0);
        }
    }
}
