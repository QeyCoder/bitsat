package day16;

/**
 * Created by Gaurav on 01/11/17.
 */
public class OnceElement {

    public static void main(String[] args) {


        int[] input = {1,2,3,1};
        int output = onceElement(input);

            System.out.println(output);
    }

    private static int onceElement(int[] input) {

        int output =   input[0];

        for (int i = 1; i <input.length ; i++) {
            output^=input[i];
        }
        return output;
    }

}
