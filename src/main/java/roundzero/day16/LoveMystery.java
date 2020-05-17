package roundzero.day16;

import java.util.Scanner;

public class LoveMystery {

    static int theLoveLetterMystery(String s) {
        int cost = 0;
        for (int i = 0; i < s.length() / 2; i++) {


            char char1 = s.charAt(i);
            char char2 = s.charAt(s.length() - i - 1);

            cost += getCost(char1, char2);


        }
        return cost;
    }

    private static int getCost(char char1, char char2) {
        if (char1 == char2) {
            return 0;
        } else {
            int cost = char1 - char2;
            return cost > 0 ? cost : -cost;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }
}
