package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//https://www.hackerearth.com/codearena/ring/7496822/
class BobContractor {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {

            int ip = Integer.parseInt(br.readLine());

            BigInteger two = new BigInteger("2");
            BigInteger three = new BigInteger("3");
            System.out.println(two.pow(ip - 1).multiply(three).mod(new BigInteger("1000000007")));


        }


    }
}
