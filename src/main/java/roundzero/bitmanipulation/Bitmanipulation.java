package roundzero.bitmanipulation;

/**
 * Created by Gaurav on 22/04/18.
 */


public class Bitmanipulation {


    public static void main(String[] args) {

        String[] strings =  {"s","s","a"};
        System.out.println(strings);
        System.out.println(getSum(5,10));
    }

    /**
     * Set bit count
     *
     * @param n
     * @return
     */
    static int count_one(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }




    static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1); //be careful about the terminating condition;
    }
}
