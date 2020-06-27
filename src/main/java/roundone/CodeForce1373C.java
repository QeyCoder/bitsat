package roundone;

import java.util.Scanner;

public class CodeForce1373C {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            solve(scanner.nextLine());
        }
    }

    private static void solve(String s) {

        int[] tmp = new int[s.length()];
        if (s.charAt(0) == '-') {
            tmp[0] = -1;
        } else {
            tmp[0] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                tmp[i] = tmp[i - 1] - 1;
            } else {
                tmp[i] = tmp[i - 1] + 1;
            }
        }


        int j = -1;
        int ans = 0;
        boolean found = false;
        while (!found) {
            int x = 0;
            while (x < tmp.length && tmp[x] != j) {
                x++;
            }
            if (x == tmp.length) {
                found = true;
            }
            ans += x+1;
            j--;
        }
        System.out.println(ans-1);
    }
}
