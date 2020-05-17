package roundzero.thoughtWorks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by Gaurav on 15/04/18.
 */


class IntegerBrowser {
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

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;

        }

        public char[] readCharArray(int size) {
            char[] array = new char[size];
            for (int i = 0; i < size; i++)
                array[i] = readCharacter();
            return array;
        }

        public int[][] readTable(int rowCount,
                                 int columnCount) {
            int[][] table = new int[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++)
                table[i] = readIntArray(columnCount);
            return table;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }


    }

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int totalFile = fastInputReader.readInt();
            int speed = fastInputReader.readInt();

            int[] files = fastInputReader.readIntArray(totalFile);

            stringBuilder.append(solution(files, speed)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static long solution(int[] files, double speed) {
        Arrays.sort(files);
        double fileLeft = files.length;
        double currentSpeed = Math.floor(speed / fileLeft);
        double minFile = files[0];
        double downloadCount = 0d;
        double totalTime = 0d;
        double last = 0d;

        for (int i = 0; i < files.length; i++) {
            if (minFile == files[i]) {
                downloadCount++;
            } else {
                totalTime += Math.ceil(Math.abs(minFile - last) / currentSpeed);
                fileLeft -= downloadCount;
                last = files[i - 1];
                minFile = files[i];
                currentSpeed = Math.floor(speed / fileLeft);
                downloadCount = 1;
            }

        }
        return (long) (totalTime + Math.ceil(Math.abs(files[files.length - 1] - last) / speed));
    }

}
