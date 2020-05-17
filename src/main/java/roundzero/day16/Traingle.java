package roundzero.day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 21/11/17.
 */
public class Traingle {

    //private static BigInteger three = new BigInteger("3");
    //private static BigInteger two = new BigInteger("2");
    //private static BigInteger mod = new BigInteger("1000000007");

    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            long x = scanner.nextLong();
            System.out.println(((2 * pow(3L, x) % mod)) - 1  );
            //System.out.println(three.pow(scanner.nextInt()).multiply(two).subtract(BigInteger.ONE).mod(mod));
            ///System.out.println(pow(2,3));

        }
    }

    static long pow(long x, long n) {


        long res = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = (res * x)  % mod;
            }
            x = (x * x ) % mod;
            n = n >> 1;
        }
        return res;
    }
}