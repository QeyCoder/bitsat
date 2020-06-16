package roundone;

import java.util.Scanner;
//https://codeforces.com/contest/1367
public class ShortSubString {


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(solve(scanner.nextLine()));
        }
    }

    private static String solve(String s) {
        StringBuilder stringBuilder
                = new StringBuilder();
        stringBuilder.append(s.charAt(0));
        for (int i = 1; i < s.length() - 1; i += 2) {
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(s.charAt(s.length() - 1));
        return stringBuilder.toString();
    }
}
