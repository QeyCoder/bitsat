package roundzero.seagmentTree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gaurav on 29/01/18.
 */
public class LeepuAndArray {


//Seagment Tree SOlution
    public static void main(String[] args) {


        Scanner scanner
                = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());


        String[] splittedArray = scanner.nextLine().split(" ");
        int[] data = Arrays.stream(splittedArray).mapToInt(Integer::parseInt).toArray();
        int ipSize = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < ipSize; j++) {

            int input = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < data.length; i++) {
                if (data[i] > input) {
                    data[i]= data[i]-1;
                }
            }
        }
        Arrays.stream(data).forEach(value -> {
            System.out.print(value + " ");
        });
    }





















//Naive CloudDay
    public static void main1(String[] args) {


        Scanner scanner
                = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());


        String[] splittedArray = scanner.nextLine().split(" ");
        int[] data = Arrays.stream(splittedArray).mapToInt(Integer::parseInt).toArray();
        int ipSize = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < ipSize; j++) {

            int input = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < data.length; i++) {
                if (data[i] > input) {
                    data[i]= data[i]-1;
                }
            }
        }
        Arrays.stream(data).forEach(value -> {
            System.out.print(value + " ");
        });
    }
}
