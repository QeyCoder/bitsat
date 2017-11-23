package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 20/11/17.
 */
public class NaughtyNumber {

    static boolean[] prime = new boolean[100001];

    public static void main(String args[]) throws Exception {


        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer query = Integer.parseInt(br.readLine());                // Reading input from STDIN
        for (int i = 0; i < prime.length; i++) {
            prime[i] = isPrime(i);
        }

        for (int i = 0; i < query; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int count = 0;
            for (int j = a; j <= b; j++) {
                if (solution(j)) {
                    count++;
                }
            }
            System.out.println(count);

        }
    }

    static boolean solution(int n) {
        int temp = n;
        int primeFactor = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {

                if (Math.sqrt(n) == i && i == n / i) {

                    if (prime[i] == true) {

                        primeFactor++;
                    }

                } else {

                    if (prime[i] == true) {

                        primeFactor++;
                    }
                    if (prime[n / i] == true) {

                        primeFactor++;
                    }
                }
            }
        }
        int noOfDigit = 1;


        while (temp / 10 != 0) {
            noOfDigit++;
            temp /= 10;
        }
        if (noOfDigit == primeFactor) {
            return true;
        }
        return false;
    }

    static boolean isPrime(int no) {
        if (no < 2) {
            return true;
        } else {
            for (int i = 2; i * i < no; i++) {
                if (no % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }
}
