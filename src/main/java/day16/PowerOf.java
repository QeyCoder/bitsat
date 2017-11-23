package day16;

/**
 * Created by Gaurav on 01/11/17.
 */
public class PowerOf {

    public static void main(String[] args) {


        int n = 24;
        int x = 5;
        //System.out.println(printPower(x,y));
        System.out.println(getRemainder(100, 7));

        System.out.println(  1 + Math.log(n & ~(n-1))/Math.log(2));
    }

    static int getRemainder(int num, int divisor) {
        return (num - divisor * (num / divisor));
    }
}
