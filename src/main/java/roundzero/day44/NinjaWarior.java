package roundzero.day44;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 01/02/18.
 */
public class NinjaWarior {
    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader(System.in);
        int T = fastInputReader.readInt();

        for (int i = 0; i < T; i++) {
            int L = fastInputReader.readInt();
            int R = fastInputReader.readInt();
            long ans = 0;
            for (int j = L; j <= R; j++) {
                ans += solution(j);
            }
            System.out.println(ans);

        }
    }

    private static long solution(int j) {

        int sum = 0;
        int copy = j;
        while (j != 0) {
            int temp = j % 10;
            sum += power(temp, temp);
            j /= 10;
        }
        return copy % sum == 0 ? 1 : 0;
    }

    static int power(int x, int y) {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }

}
