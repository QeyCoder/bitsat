package roundone;

import java.util.Scanner;

public class Solution50_A {


    public static void main(String args[]) {

        Scanner scanner
                = new Scanner(System.in);

        String[] ip = scanner.nextLine().split(" ");
        int x = Integer.parseInt(ip[0]);
        int y = Integer.parseInt(ip[1]);


        if (x % 2 == 0 && y % 2 == 0) {
            System.out.println((x * y) / 2);
            return;
        } else if (x % 2 == 0) {
            y -= 1;
            System.out.println((x * y )/ 2 + x / 2);
        } else if (y % 2 == 0) {
            x-=1;
            System.out.println((x * y )/ 2 + y / 2);
        }else{
            x-=1;
            y-=1;
            System.out.println((x * y )/ 2 + y / 2+x/2);

        }
    }
}
