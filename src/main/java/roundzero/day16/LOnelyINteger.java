package roundzero.day16;

import java.util.Scanner;

public class LOnelyINteger {

    static int lonelyinteger(int[] a) {

        int buff[] = new int[100];

        for (int i = 0; i < a.length; i++) {
            buff[a[i]]++;
        }
        for (int i = 0; i < buff.length; i++) {
            if (buff[i] == 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        //int result = lonelyinteger(a);
        int result = lonelyintegerXorApproach(a);
        System.out.println(result);
    }

    private static int lonelyintegerXorApproach(int[] a) {
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            result = result ^ a[i];
        }
        return result;
    }
}
