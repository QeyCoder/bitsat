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

        long data = 1;
        long ans = 0;
        for (int i = 0; i <= tmp.length; i++) {
            if (i != tmp.length && tmp[i] == -data) {
                ans += i + 1;
                data++;

            } else if(i== tmp.length){
                ans += tmp.length;
            }

        }
        System.out.println(ans);
    }
}
