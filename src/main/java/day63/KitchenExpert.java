package day63;

import template.FastInputReader;

/**
 * Created by Gaurav on 03/04/18.
 */


public class KitchenExpert {


    static class A {
        int x = 9;
        static int y = 3;
    }

    public static void main(String[] args) {

        A a = null;

        System.out.println(a.y);
        System.out.println(a.x);
    }

    static char V = 'V';
    static char N = 'N';
    static char G = 'G';
    static char TO = 'T';
    static char S = 'S';
    static char B = 'B';
    static char P = 'P';

    static int VEG;
    static int NONVEG;
    static int GRILL;
    static int TOAST;
    static int SANDWICH;
    static int BURGER;
    static int PIZZA;

    static long V1;
    static long N1;
    static long G1;
    static long T1;
    static long S1;
    static long B1;
    static long P1;

    public static void smain(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        String ip = fastInputReader.readString();
        for (int i = 0; i < ip.length(); i++) {

            char c = ip.charAt(i);

            if (c == V) VEG++;
            if (c == N) NONVEG++;
            if (c == G) GRILL++;
            if (c == TO) TOAST++;
            if (c == S) SANDWICH++;
            if (c == B) BURGER++;
            if (c == P) PIZZA++;
        }


        int M = fastInputReader.readInt();


        for (int i = 0; i < M; i++) {
            String order = fastInputReader.readString();
            long total = 1;
            for (int j = 0; j < 3; j++) {
                char c = order.charAt(j);
                if (c == V) total *= VEG--;
                total %= (1e9 + 7);
                if (c == N) total *= NONVEG--;
                total %= (1e9 + 7);
                if (c == G) total *= GRILL--;
                total %= (1e9 + 7);
                if (c == TO) total *= TOAST--;
                total %= (1e9 + 7);
                if (c == S) total *= SANDWICH--;
                total %= (1e9 + 7);
                if (c == B) total *= BURGER--;
                total %= (1e9 + 7);
                if (c == P) total *= PIZZA--;
                total %= (1e9 + 7);

            }
            System.out.println(total);
        }


    }


}
