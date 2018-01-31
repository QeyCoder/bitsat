package day43;

import template.InputReader;

/**
 * Created by Gaurav on 31/01/18.
 */
public class PerfectNumber {

    public static void main(String[] args) {


        InputReader inputReader
                = new InputReader(System.in);
        int n = inputReader.readInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int i = 1;
        int bigInteger = 19;
        while (i != n) {
            bigInteger++;
            if (isSumTen(String.valueOf(bigInteger))) {
                i++;
            }
        }
        return bigInteger;
    }

    private static boolean isSumTen(String bigInteger) {
        int sum = 0;
        for (int i = 0; i < bigInteger.length(); i++) {
            sum += (int) bigInteger.charAt(i)-'0';
        }
        return sum == 10;

    }
}