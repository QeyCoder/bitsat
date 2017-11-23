package day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 02/11/17.
 */
public class LADERPRINT {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        char[][] chars = new char[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                chars[i][j] = ' ';
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= n - i - 1; j--) {
                chars[i][j] = '#';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
    }
}
