package projectEuler;

import java.util.Scanner;

/**
 * Created by Gaurav on 04/02/18.
 */
//prob-1
public class Problem1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int a0 = 0; a0 < t; a0++) {

            int n = in.nextInt();
            long a = (n - 1) / 3;
            long b = (n - 1) / 5;
            long c = (n - 1) / 15;


            System.out.println((3 * a * (a + 1) / 2) + (5 * b * (b + 1) / 2) - (15 * c * (c + 1) / 2));
        }


    }

}


