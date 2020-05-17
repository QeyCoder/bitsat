package day64;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gaurav on 08/04/18.
 */


public class LongestWords {


    public static void main(String[] args) {
        LongestWords longestWords = new LongestWords();
        System.out.println(longestWords.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));

    }

    public String longestWord(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());

        Set<String> hash = new HashSet<>();
        String max = "";
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            hash.add(current);
        }

        for (int i = 0; i < words.length; i++) {
            boolean found = true;
            String current = words[i];
            for (int j = 0; j < current.length(); j++) {

                if (!hash.contains(current.substring(0, j + 1))) {
                    found = false;
                    break;
                }

            }
            if (found) return current;

        }
        return "";
    }

}
