package day5;

import java.math.BigInteger;

/**
 * Created by Gaurav on 02/10/17.
 */
public class FibonacciFunction {
    BigInteger[] fibonacci;

    public static void main(String[] args) {
        FibonacciFunction fibonacciFunction = new FibonacciFunction();
        System.out.println(fibonacciFunction.function(8181));
        System.out.println(fibonacciFunction.function(10));
    }

    /**
     *
     * @param i
     * @return
     */
    private BigInteger function(int i) {
        fibonacci = new BigInteger[i + 1];
        fibonacci[0] = BigInteger.ZERO;
        fibonacci[1] = BigInteger.ONE;


        for (int j = 2; j <= i; j++) {
            fibonacci[j] = fibonacci[j - 1].add(fibonacci[j - 2]);
        }
        return fibonacci[i];

    }
}
