package day5;

/**
 * Created by Gaurav on 02/10/17.
 */
public class TrailingZero {
    int[] factorial;

    public static void main(String[] args) {
        TrailingZero trailingZero = new TrailingZero();
        System.out.println(trailingZero.findTrailingZeroInFactorial(9446865));


    }

    private int findTrailingZeroInFactorial(int number) {
        int count = 0;

        for (int j = 5; number / j >= 1; j *= 5) {
            count += number / j;
        }


        return count;


    }
}
