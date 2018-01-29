package day42;

import java.util.Scanner;

/**
 * Created by Gaurav on 26/01/18.
 */
public class ArrayAndQueries {

    public static void main(String[] args) {

        Scanner scanner
                = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[] spltd = scanner.nextLine().split(" ");
        int q = Integer.parseInt(scanner.nextLine());
        int[] ids =  new int[q];
        int[] vals =  new int[q];
        for (int i = 0; i < q; i++) {
            String[] data = scanner.nextLine().split(" ");
            ids[i] = Integer.parseInt(data[0]);
            vals[i] = Integer.parseInt(data[1]);
        }





    }
}
