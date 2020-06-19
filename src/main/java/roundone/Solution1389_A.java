package roundone;

import java.util.Scanner;

public class Solution1389_A {

    //https://codeforces.com/contest/1368/problem/0
    public static void main(String args[]) {

        Scanner scanner
                = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {

            String[] ip = scanner.nextLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);

            int count = 1;
            while (a + b <= c) {
                count++;
                if (a > b) {
                    b = a + b;
                } else {
                    a = a + b;
                }
            }
            System.out.println(count);

        }

    }
}
