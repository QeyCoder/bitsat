package day11;

import java.math.BigInteger;

/**
 * Created by Gaurav on 09/10/17.
 */
public class Power2 {
    public int powe1r(String A) {
        if (A.equals("1") || A.equals("0")) {
            return 0;
        }
        BigInteger val = new BigInteger(A);
        double log = Math.log(val.doubleValue()) / Math.log(2);

        int log1 = (int) log;
        if (log - log1 < 0.000001) {
            return 1;
        }
        return 0;
    }

    public int power(String A) {
        if (A.equals("1") || A.equals("0")) {
            return 0;
        }
        BigInteger val = new BigInteger(A);
        BigInteger two = new BigInteger("2");
        while (val.compareTo(two) >0) {

            if (val.mod(two) != BigInteger.ZERO) {
                return 0;
            }
            val = val.divide(two);
        }
        return 1;
    }

    public static void main(String[] args) {
        Power2 power2
                = new Power2();
        //System.out.println(power2.power("64"));

    }



}
