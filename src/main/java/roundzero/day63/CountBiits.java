package day63;

/**
 * Created by Gaurav on 07/04/18.
 */


public class CountBiits {


    public static void main(String[] args) {
        getBit(4);

    }

    public static int[] countBits(int num) {
        int[] arrr = new int[num + 1];
        for (int i = 0; i <= num; i++) {

            arrr[i] = getBit(i);
        }
        return arrr;
    }

    private static int getBit(int i) {

        int count = 0;
        while (i != 0) {
            count += i & 1;
            i >>= 1;

        }
        return count;
    }

}
