package roundone;

import java.util.Scanner;

public class CodeForce1373D {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            scanner.nextLine();
            solve(scanner.nextLine());
        }
    }

    private static void solve(String s) {
        String[] ip = s.split(" ");
        long[] conv = new long[ip.length];
        for (int i = 0; i < ip.length; i++) {
            conv[i] = Long.parseLong(ip[i]);
        }

        long evenSum = 0;

        for (int i = 0; i < conv.length; i++)
            if (i % 2 == 0) evenSum += conv[i];

        long maxDif=0, perSum = 0;
        for (int i = 1; i < ip.length; i+=2) {
            perSum = Math.max(perSum + conv[i] - conv[i - 1], 0);
            maxDif = Math.max(maxDif, perSum);

        }
        perSum = 0;
        for (int i = 1; i < ip.length-1; i+=2) {
            perSum = Math.max(perSum + conv[i] - conv[i + 1], 0);
            maxDif = Math.max(maxDif, perSum);

        }
        System.out.println(evenSum+ maxDif);
    }
}
