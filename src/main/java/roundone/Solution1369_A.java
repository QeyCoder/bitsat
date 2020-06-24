package roundone;

import java.util.Scanner;

public class Solution1369_A {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            solution(scanner.nextLine());
        }
    }

    private static void solution(String s) {
        long no = Long.parseLong(s);


        System.out.println((no * 90) % 360 == 0 ? "YES" : "NO");


    }
}
