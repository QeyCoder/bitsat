package day42;

import java.util.Scanner;

/**
 * Created by Gaurav on 26/01/18.
 */
public class GameDay {

    public static void main(String[] args) {

        Scanner scanner
                = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            int N = Integer.parseInt(scanner.nextLine());

            long[] data = new long[N];
            String[] spltd = scanner.nextLine().split(" ");
            long max = -1;
            for (int j = 0; j < N; j++) {
                data[j] = Long.parseLong(spltd[j]);
                if (data[j] > max) {
                    max = data[j];
                }
            }

            if (max > N) {
                System.out.println(max);
            } else {
                System.out.println(max + 1);
            }


        }


    }
}
