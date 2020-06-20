package roundone;

import java.util.Scanner;

public class Solution200B {


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        float size = Float.parseFloat(scanner.nextLine());

        String[] ip = scanner.nextLine().split(" ");
        float tot = 0;
        for (String s : ip) {
            tot += Float.parseFloat(s);
        }
        System.out.printf("%.12f" , (tot / size));


    }
}
