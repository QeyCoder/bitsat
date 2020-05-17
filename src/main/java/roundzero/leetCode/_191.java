package leetCode;

/**
 * Created by Gaurav on 29/04/18.
 */


public class _191 {

    public static void main(String[] args) {
        _191 ref = new _191();
        System.out.println(ref.hammingWeight(2147483648l));
        System.out.println(ref.hammingWeight(18));
        System.out.println(ref.hammingWeight(4));
    }

    public int hammingWeight(long n) {

        int count = 0;


        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;


    }


    public int hammingWeight1(long n) {

        int count = 0;


        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;


    }


}
