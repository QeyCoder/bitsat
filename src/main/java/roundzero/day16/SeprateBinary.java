package roundzero.day16;

/**
 * Created by Gaurav on 01/11/17.
 */
public class SeprateBinary {

    public static void main(String[] args) {


        int[] input = {1,0,0,0,1,1,0,1};
        int[] output = seprateBinary(input);

        for (int i : output) {
            System.out.println(i);
        }
    }

    private static int[] seprateBinary(int[] input) {
        int left = 0;
        int right = input.length - 1;


        while (left <right) {

            int zero = input[left];
            int one = input[right];


            if (zero == 0 && one == 1) {
                left++;
                right--;
            } else if (zero == 1 && one == 0) {
                input[left] = 0;
                input[right] = 1;
                left++;
                right--;
            } else if (zero == 0 && one == 0) {
                left++;

            } else if (zero == 1 && one == 1) {
                right--;
            }
        }
        return input;
    }
}
