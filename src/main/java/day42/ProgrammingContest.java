package day42;

import java.util.Scanner;

/**
 * Created by Gaurav on 26/01/18.
 */
//https://www.hackerrank.com/contests/hackerrank-hiring-contest/challenges/programming-competition
public class ProgrammingContest {


    public static void main(String[] args) {
        Scanner scanner
                = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] name = new String[size];
        int[] d = new int[size];
        int[] j = new int[size];
        int max = -1;
        int q = -1;
        for (int i = 0; i < size; i++) {
            String[] spltd = scanner.nextLine().split(" ");
            name[i] = spltd[0];
            d[i] = Integer.parseInt(spltd[1]);
            j[i] = Integer.parseInt(spltd[2]);
            int diff = j[i] - d[i];

            if (diff > max) {
                max = diff;
                q = i;
            }
        }
        System.out.println(name[q] + " " + max);


    }
}
