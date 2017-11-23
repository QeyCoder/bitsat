package day123;

/**
 * Created by Gaurav on 01/09/17.
 */
public class PrimeSum {


    void findNumber(int inputNumber) {

        for (int i = inputNumber / 2; i >= 2; i--) {
            if (isPrime(inputNumber - i) && isPrime(i)) {
                System.out.println(i + "-" + (inputNumber - i));
            }
        }


    }

    private boolean isPrime(int A) {
        if (A == 1 || A == 0

                ) {
            return false;
        }
        if (A == 2)
            return true;
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0)
                return true;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeSum primeSum = new PrimeSum();
        primeSum.findNumber(4);
    }
}
