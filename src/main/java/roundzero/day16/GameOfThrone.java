package roundzero.day16;

import java.util.Scanner;

public class GameOfThrone {

    static String isPalindromicAnagram(String s1) {

        int[] str1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            str1[s1.charAt(i) - 97]++;
        }
        boolean odd = false;
        for (int i = 0; i < 26; i++) {


            if (str1[i] % 2 != 0) {
                if (!odd) {
                    odd = true;
                } else {
                    return "NO";
                }

            }

        }
        return "YES";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String result = isPalindromicAnagram(s1);
        System.out.println(result);
    }
}
