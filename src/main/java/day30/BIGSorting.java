package day30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/big-sorting/problem
public class BIGSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.next();
        }

        solution(unsorted);
    }

    private static void solution(String[] unsorted) {

        Comparator<String> comp = new BigSortComp();
        Arrays.sort(unsorted, comp);
        for (int i = 0; i < unsorted.length; i++) {

            System.out.println(unsorted[i]);
        }

    }

    private static class BigSortComp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {


            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {

                for (int i = 0; i < o1.length(); i++) {

                    char a = o1.charAt(i);
                    char b = o2.charAt(i);
                    if (a != b) {
                        return a - b;
                    }
                }

            }

            return 0;
        }

    }
}
