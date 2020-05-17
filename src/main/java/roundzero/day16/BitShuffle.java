package roundzero.day16;

/**
 * Created by Gaurav on 01/11/17.
 */
public class BitShuffle {


    public static void main(String[] args) {
        System.out.println(findBitShuffleRequired(10, 20));
    }

    private static int findBitShuffleRequired(int i, int j) {

        int k = i ^ j;
        int count = 0;
        while (k > 0) {
           k&=k-1;
            count++;
        }
        return count;
    }
}
