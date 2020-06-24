package roundone;

import java.util.Scanner;

public class Solution1369B {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            solve(n, new StringBuilder(s));

        }
    }

    private static void solve(int n, StringBuilder s) {

        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                break;
            }
        }
        boolean mid = false;
        if (zero + one < n) {
            mid = true;
        }

        StringBuilder ans = new StringBuilder();
        if (mid) {

            for (int i = 0; i <= zero; i++) {
                ans = ans.append("0");
            }
            for (int i = 0; i < one; i++) {
                ans = ans.append("1");
            }


        } else {
            for (int i = 0; i < zero; i++) {
                ans = ans.append("0");
            }
            for (int i = 0; i < one; i++) {
                ans = ans.append("1");
            }

        }

        System.out.println(ans.toString());


    }
}
