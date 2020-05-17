package roundzero.day16;

import java.util.Scanner;

public class BeautifulStr {

    static int minSteps(int n, String B) {
        return (B.length() - B.replaceAll("010", "").length()) / 3;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();
        int result = minSteps(n, B);
        System.out.println(result);
    }
}
