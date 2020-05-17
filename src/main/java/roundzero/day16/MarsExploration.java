package roundzero.day16;

import java.util.Scanner;

public class MarsExploration {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        solve(S);


    }

    private static void solve(String s) {
        int count = 0;

        for (int i = 0; i < s.length() - 2; i = i + 3) {

            char S = s.charAt(i);
            char O = s.charAt(i + 1);
            char S1 = s.charAt(i + 2);
            if (S != 'S') {
                count++;
            }
            if (O != 'O') {
                count++;
            }
            if (S1 != 'S') {
                count++;
            }

        }
        System.out.println(count);
    }
}
