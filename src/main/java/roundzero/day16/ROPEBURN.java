package roundzero.day16;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Gaurav on 09/11/17.
 */
public class ROPEBURN {


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int tc = reader.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int length = reader.nextInt();
            String[] up = reader.readLine().split(" ");
            String[] down = reader.readLine().split(" ");
            stringBuilder.append(solution(length, up, down)).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
        reader.close();
    }

    static class Reader {

        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;

        private byte[] buffer;

        private int bufferPointer, bytesRead;


        public Reader() {

            din = new DataInputStream(System.in);

            buffer = new byte[BUFFER_SIZE];

            bufferPointer = bytesRead = 0;

        }


        public Reader(String file_name) throws IOException {

            din = new DataInputStream(new FileInputStream(file_name));

            buffer = new byte[BUFFER_SIZE];

            bufferPointer = bytesRead = 0;

        }


        public String readLine() throws IOException {

            byte[] buf = new byte[10000000]; // line length

            int cnt = 0, c;

            while ((c = read()) != -1)

            {

                if (c == '\n')

                    break;

                buf[cnt++] = (byte) c;

            }

            return new String(buf, 0, cnt);

        }


        public int nextInt() throws IOException

        {

            int ret = 0;

            byte c = read();

            while (c <= ' ')

                c = read();

            boolean neg = (c == '-');

            if (neg)

                c = read();

            do

            {

                ret = ret * 10 + c - '0';

            } while ((c = read()) >= '0' && c <= '9');


            if (neg)

                return -ret;

            return ret;

        }


        public long nextLong() throws IOException {

            long ret = 0;

            byte c = read();

            while (c <= ' ')

                c = read();

            boolean neg = (c == '-');

            if (neg)

                c = read();

            do {

                ret = ret * 10 + c - '0';

            }

            while ((c = read()) >= '0' && c <= '9');

            if (neg)

                return -ret;

            return ret;

        }


        public double nextDouble() throws IOException {

            double ret = 0, div = 1;

            byte c = read();

            while (c <= ' ')

                c = read();

            boolean neg = (c == '-');

            if (neg)

                c = read();


            do {

                ret = ret * 10 + c - '0';

            }

            while ((c = read()) >= '0' && c <= '9');


            if (c == '.')

            {

                while ((c = read()) >= '0' && c <= '9')

                {

                    ret += (c - '0') / (div *= 10);

                }

            }


            if (neg)

                return -ret;

            return ret;

        }


        private void fillBuffer() throws IOException {

            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);

            if (bytesRead == -1)

                buffer[0] = -1;

        }


        private byte read() throws IOException {

            if (bufferPointer == bytesRead)

                fillBuffer();

            return buffer[bufferPointer++];

        }


        public void close() throws IOException {

            if (din == null)

                return;

            din.close();

        }


    }

    private static int solution1(int length, String[] up, String[] down) {
        int[] dp = new int[1000000];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(1 + dp[i - 1], Math.max(dp[i - 1] + Integer.parseInt(up[i - 1]), dp[i - 1] + Integer.parseInt(down[i - 1])));
        }
        return dp[length - 1] + 1;
    }

    private static int solution(int length, String[] up, String[] down) {

        int maxUpLength = getMaxLength(up);
        int maxDownLength = getMaxLength(down);

        if (length > maxUpLength && length > maxDownLength) {
            return length;
        } else if (maxDownLength > maxUpLength) {
            return maxDownLength;
        } else {
            return maxUpLength;
        }


    }

    static int getMaxLength(String[] array) {
        int max = 1 + Integer.parseInt(array[0]);
        for (int i = 1; i < array.length; i++) {
            int value = Integer.parseInt(array[i]);

            if (value + i + 1 > max) {
                max = value + i + 1;
            }
        }
        return max;
    }

    private static int getBalanceLength(String up, String down) {
        int u = Integer.parseInt(up);
        int d = Integer.parseInt(down);

        int balance = 0;
        if (u > 0) {
            u--;
        }
        if (d > 0) {
            d--;
        }

        return balance >= 0 ? balance : -balance;
    }
}
