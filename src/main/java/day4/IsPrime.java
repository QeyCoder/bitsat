package day4;

/**
 * Created by Gaurav on 01/10/17.
 */
public class IsPrime {

    public int isPrime(int a) {
        if (a == 0 || a == 1) {
            return 0;
        }
        boolean isPrime = true;
        if(a%2==0){
            return 0;
        }
        for (int i = 3; i <= Math.sqrt(a) ; i=i+2) {
            if (a % i == 0) {
                isPrime = false;
            }
        }
        return isPrime ? 1 : 0;
    }

    public static void main(String[] args) {
        IsPrime isPrime = new IsPrime();
        System.out.println(isPrime.isPrime(7));
        System.out.println(isPrime.isPrime(31));
        System.out.println(isPrime.isPrime(28));
        System.out.println(isPrime.isPrime(41));
    }
}
