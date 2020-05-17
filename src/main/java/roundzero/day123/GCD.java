package roundzero.day123;

/**
 * Created by Gaurav on 30/09/17.
 */
public class GCD {


    public int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a > b ? a : b;
        }
        int small;
        int big;
        if (a > b) {
            small = b;
            big = a;

        } else {
            small = a;
            big = b;
        }

        while (a % small != 0 || b % small != 0) {
            small -= 1;
        }

        return small;
    }

  static void main(String[] args) {
        GCD gcd =  new GCD();
        System.out.println(gcd.gcd(4, 6));
    }
}
