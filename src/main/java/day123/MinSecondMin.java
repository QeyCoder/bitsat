package day123;

/**
 * Created by Gaurav on 15/10/17.
 */
public class MinSecondMin {


    public static void main(String[] args) {


        int[] array = {7,3,2,1};
        printNumber(array);
    }

    private static void printNumber(int[] array) {


        int min = array[0];
        int secondmin =array[1];

        for (int i = 0; i < array.length; i++) {
            int no = array[i];
            if (no < min) {
                secondmin = min;
                min = no;

            }
        }
        System.out.println(min);
        System.out.println(secondmin);
    }
}
