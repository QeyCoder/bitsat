package womenCodeSprint;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Gaurav on 10/03/18.
 */


public class Problem1 {

    static int howMuchToAsk(int c, int p) {
        /*
         * Return the amount the cashier should ask the customer or -1 if this exceeds 9.
         */

        int[] change = {20, 50, 100, 200, 500, 1000};
        int selection = -1;


        int ret = p - c;
        if (ret <= 9) {
            return ret;
        }
        int diff = Integer.MAX_VALUE;


        for (int i = 0; i < change.length; i++) {
            if (change[i] - ret > 0 && change[i] - ret < diff) {
                selection = change[i];
                diff = change[i] - ret;
                break;
            }
        }

        int op = selection - ret;

        for (int i = 0; i < change.length; i++) {
            if (ret == change[i]) {
                return 0;
            }
        }


        for (int i = 0; i < change.length; i++) {
            if (Math.abs(ret - change[i]) <= 9) {
                return Math.abs(ret - change[i]);
            }
        }
        return -1;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(scan.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] cp = scan.nextLine().split(" ");

            int c = Integer.parseInt(cp[0].trim());

            int p = Integer.parseInt(cp[1].trim());

            int result = howMuchToAsk(c, p);
            System.out.println(String.valueOf(result));
        }

    }
}
