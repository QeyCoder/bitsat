package roundzero.day16;

import java.util.Scanner;

public class KangarroJump {

    static String kangaroo(int x1, int v1, int x2, int v2) {

        boolean match = true;
        if ((v1 > v2 && x1 > x2) || (v2 > v1 && x2 > x1)) {
            match = false;
        } else if ((v1 != v2) && (x2 - x1) % (v2 - v1) == 0) {
            match = true;
        } else {
            match = false;
        }

        return match ? "YES" : "NO";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
