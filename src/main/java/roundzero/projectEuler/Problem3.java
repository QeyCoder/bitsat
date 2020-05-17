package projectEuler;

import java.util.Scanner;

//prob-3 pending
public class Problem3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();

            System.out.println(solution(n));
        }
    }

    private static boolean solution(long n) {
        if (n % 2 == 0) {
            while (n != 1) {
                n /= 2;
            }
        } else {
            for (int i = 3; i * i <= n; i += 2) {


            }
        }
        return true;
    }
}


