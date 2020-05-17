package roundzero.seagmentTree;

/**
 * Created by Gaurav on 30/01/18.
 */
public class SumOfArray {

    public static void main(String[] args) {


        int[] a = {1, 1, 9};
        int[] b = {9,1};
        int min = 2;
        int max=3;
        int sum = 0;
        int carry = 0;
        for (int i = min; i > 0; i--) {

            int temp = b[min-1] + a[max-1];
            System.out.println(temp);

        }
    }

    private static int min(int length, int length1) {
        return length < length1 ? length : length1;
    }
}
