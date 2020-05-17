package day6;

/**
 * Created by Gaurav on 03/10/17.
 */
public class PowerOfInteger {

    boolean is_x_pow_y(int n) {
        if (n == 1) return true;

    /* in a reversed order  slightly faster */
        for (int i = (int) Math.sqrt(n); i >= 2; i--) {
            int t = n;
        /* if t > 1 and t can be divided by i */
            while (t > 1 && t % i == 0)
                t /= i;
            if (t == 1) return true;
        }

        return false;
    }

    public int isPower(int A) {
        for (int i = (int) Math.sqrt(A); i >= 2; i--) {
            int temp = A;
            while (temp > 1 && temp % i == 0) {
                temp /= i;
            }
            if (temp == 1) {
                return 1;

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        PowerOfInteger powerOfInteger = new PowerOfInteger();
        System.out.println(powerOfInteger.isPower(4));
        System.out.println(powerOfInteger.is_x_pow_y(4));
    }
}
