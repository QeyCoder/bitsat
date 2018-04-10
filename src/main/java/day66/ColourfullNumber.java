package day66;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gaurav on 10/04/18.
 */


public class ColourfullNumber {


    public static void main(String[] args) {
        ColourfullNumber colourfullNumber = new ColourfullNumber();
       // System.out.println(colourfullNumber.colorful(3245));
        System.out.println(colourfullNumber.colorful(123));
    }

    public int colorful(int A) {

        String s = String.valueOf(A);

        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                sub = sub.trim();
                if (sub.length() == 0) {
                    continue;
                }
                int product = product(sub);
                if (integers.contains(product)) {
                    return 0;
                }
                integers.add(product);
            }
        }
        return 1;
    }

    private int product(String sub) {
        int prod = 1;
        for (int i = 0; i < sub.length(); i++) {
            prod *= (int) sub.charAt(i) - '0';
        }
        return prod;


    }

}
