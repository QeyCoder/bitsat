package roundone;

import java.util.Scanner;
//https://codeforces.com/contest/1367
public class EvenArray {


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            System.out.println(solve(scanner.nextLine()));
        }
    }

    private static int solve(String arr) {
        int even = 0, odd = 0;
        String[] spltd = arr.split(" ");
        for (int i = 0; i < spltd.length; i++) {
            if (i % 2 == 0 && Integer.parseInt(spltd[i]) % 2 != 0) {
                even++;
            }
            if (i % 2 != 0 && Integer.parseInt(spltd[i]) % 2 == 0) {
                odd++;
            }
        }
        return odd==even? odd:-1;
    }

}
