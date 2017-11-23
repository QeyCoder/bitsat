package day16;

import java.util.Scanner;

public class APPLEORANGE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sh = in.nextInt();
        int th = in.nextInt();
        int at = in.nextInt();
        int ot = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int noOfApp = 0;
        int noOfO = 0;
        for (int apple_i = 0; apple_i < m; apple_i++) {
            int nextApple = in.nextInt()+at;
            if (nextApple >= sh && nextApple <= th) {
                noOfApp++;
            }
        }

        for (int orange_i = 0; orange_i < n; orange_i++) {
            int nextOrange = in.nextInt()+ot;
            if (nextOrange >= sh && nextOrange <= th) {
                noOfO++;
            }
        }
        System.out.println(noOfApp);System.out.println(noOfO);
    }
}
