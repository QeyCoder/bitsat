package roundzero.day16;

import java.util.Scanner;

public class LetsMakeAnagram {

    static int makingAnagrams(String s1, String s2) {

        int[] str1 = new int[26];
        int[] str2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {

            str1[s1.charAt(i) - 97]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            str2[s2.charAt(i) - 97]++;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            int d = str1[i] - str2[i];
            diff += d > 0 ? d : -d;
        }
        return diff;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
