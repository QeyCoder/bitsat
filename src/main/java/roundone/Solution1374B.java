package roundone;

import java.util.Scanner;

public class Solution1374B {
    static int ans = 0;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            int ip = Integer.parseInt(scanner.nextLine());
            if (ip == 1) {
                System.out.println(0);
                continue;
            }
            if (ip % 3 > 0) {
                System.out.println(-1);
                continue;
            }
            solve(ip);
            System.out.println(ans);
            ans = 0;
        }
    }

    private static void solve(int s) {
        if (s == 1) {
            return;
        }
        if(s%3>0){
            ans= -1;
            return;
        }
        if (s % 6 == 0) {
            ans += 1;
            solve(s / 6);
        } else {
            ans += 1;
            solve(s * 2);
        }

    }

}
