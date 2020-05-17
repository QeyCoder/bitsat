package roundzero.day16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        splitCamel(s);
    }

    private static void splitCamel(String s) {
        int count = 0;
        Queue<Character> characters = new LinkedList<>();
        characters.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char val = s.charAt(i);
            if (val >= 65 && val <= 90) {
                while (characters.size() > 0) {
                    characters.poll();
                }
                count++;
            }
            characters.add(val);
        }

        System.out.printf(++count + "");
    }
}
