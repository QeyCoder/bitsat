package day16;

/**
 * Created by Gaurav on 01/11/17.
 */
public class ArrayRearrange {


    public static void main(String[] args) {
        int[] input = {2, 32, 14, 5, 12, 21, 31, 4, 1};
        int[] output = arrayRearrange(input);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    private static int[] arrayRearrange(int[] input) {

        int left = 0;
        int right = input.length - 1;

        //odd first;
        //even end;
        while (left <= right) {
            int odd = input[left];
            int even = input[right];

            if(odd%2==0 && even%2!=0){
                    swap(input,left,right);
                left++;
                right--;
            }
            if(odd%2!=0 && even%2==0){
                left++;
                right--;
            }

            if(odd%2!=0 && even%2!=0){
                left++;
            }
            if(odd%2==0 && even%2==0){
                right--;
            }

        }
        return input;
    }

    private static void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
