package roundzero.day16;

/**
 * Created by Gaurav on 31/10/17.
 */
public class MaxSubArrayProblem {

    public static void main(String[] args) {


        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        findMaxSubArray(input);
    }


    private static void findMaxSubArray(int[] input) {
        int maxSoFar = 0;
        int maxEnd = 0;

        int start = 0;
        int end = 0;
        int s = 0;
        for (int i = 0; i < input.length - 1; i++) {
            maxEnd += input[i];
            if (maxEnd < 0) {
                maxEnd = 0;
                s = i + 1;
            }
            if (maxEnd > 0 && maxEnd > maxSoFar) {
                maxSoFar = maxEnd;
                start = s;
                end = i;
            }
        }
        System.out.println(maxSoFar);
        System.out.println(start+" "+ end);
    }



}
