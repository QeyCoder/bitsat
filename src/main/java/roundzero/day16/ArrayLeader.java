package roundzero.day16;

/**
 * Created by Gaurav on 31/10/17.
 */
public class ArrayLeader {


    public static void main(String[] args) {


        int[] input = {16, 17, 4, 3, 5, 2};
        int[] output = updateLeader(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);

        }
    }

    private static int[] updateLeader(int[] input) {
        int size = input.length;
        int max = input[size - 1];
        input[size - 1] = -1;
        for (int i = size - 2; i >= 0; i--) {
            int temp = input[i];
            input[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return input;


    }
}
