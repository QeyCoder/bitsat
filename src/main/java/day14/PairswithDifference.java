package day14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gaurav on 17/10/17.
 */
public class PairswithDifference {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= cases; i++) {
            String[] noOfPairs = scanner.nextLine().split(" ");
            String[] array = scanner.nextLine().split(" ");
            int[] arrayINt = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                arrayINt[j] = Integer.parseInt(array[j]);
            }
            System.out.println(findNoOfPairs(arrayINt, Integer.parseInt(noOfPairs[1])));
        }


    }

    private static int findNoOfPairs(int[] array, int k) {

        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {

            int low = array[i];
            int high = array[i + 1];

            int diff = high - low;
            if (diff > k) {
                break;
            } else if (diff <= k) {
                count++;
            }
        }
        return count;
    }
}
