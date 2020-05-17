package roundzero.day16;

import java.util.Scanner;

public class Solution1 {

    static int[] solve(int[] a, int[] b) {
        int bob = 0;
        int alice = 0;
        for (int i = 0; i < a.length; i++) {
            int a0 = a[i];
            int b0 = b[i];
            if (a0 > b0) {
                alice += 1;
            }
            if (a0 < b0) {
                bob += 1;
            }
        }



        /*a0<b0 If, then Alice is awarded point.
        a2<b2 If, then Bob is awarded point.
        a3 = b3 If, then neither person receives a point.
*/
        return new int[]{alice, bob};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(new int[]{
                a0, a1, a2
        }, new int[]{b0, b1, b2});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


    }
}
