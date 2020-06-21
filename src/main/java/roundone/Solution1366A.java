package roundone;

import java.util.Scanner;

public class Solution1366A {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {

            String[] ip = scanner.nextLine().split(" ");
            int x = Integer.parseInt(ip[0]);
            int y = Integer.parseInt(ip[1]);

            System.out.println(Math.min(Math.min(x,y),(x+y)/3));
        }

    }
}
