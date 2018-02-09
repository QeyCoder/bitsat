package day46;

import template.FastInputReader;

/**
 * Created by Gaurav on 08/02/18.
 */
public class BarAndSteadyGen {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        String data = fastInputReader.readString();
        System.out.println(solution(data, n));
    }

    private static int solution(String data, int n) {

        n /= 4;
        int A = 0;
        int C = 0;
        int G = 0;
        int T = 0;


        for (int i = 0; i < data.length(); i++) {

            switch (data.charAt(i)) {
                case 'A':
                    A++;
                    break;
                case 'C':
                    C++;
                    break;

                case 'G':
                    G++;
                    break;
                case 'T':
                    T++;
                    break;
            }
        }
        int sum = 0;
        if (A < n) {
            sum += n - A;
        }
        if (C < n) {
            sum += n - C;
        }
        if (G < n) {
            sum += n - G;
        }
        if (T < n) {
            sum += n - T;
        }
        return sum;
    }

}
