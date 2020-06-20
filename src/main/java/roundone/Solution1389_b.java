package roundone;

import java.util.Scanner;

public class Solution1389_b {

    //https://codeforces.com/contest/1368/problem/0
    public static void main(String args[]) {

        Scanner scanner
                = new Scanner(System.in);
        long ip = scanner.nextLong();
        String code = "codeforces";


        long[] tmp = new long[10];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 1;
        }
        long product = 1;
        while (product < ip) {
            for (int i = 0; i < 10; i++) {
                product = product / tmp[i];
                tmp[i] += 1;
                product = product * tmp[i];
                if (product >= ip) {
                    break;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            while (tmp[i]-- > 0) {
                System.out.print(code.charAt(i));
            }
        }
    }


}
