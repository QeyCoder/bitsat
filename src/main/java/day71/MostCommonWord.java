package day71;

import java.util.*;

/**
 * Created by Gaurav on 27/04/18.
 */


public class MostCommonWord {


    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        System.out.println(mostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));

        System.out.println(mostCommonWord.reverseWords("   a   b "));
    }

    public String reverseWords(String s) {

        String[] ip = s.split(" ");
        StringBuilder strBldr = new StringBuilder();
        for (int i = ip.length - 1; i >= 0; i--) {
            ip[i] = ip[i].trim();
            if(!ip[i].equals(""))
            strBldr.append(ip[i]).append(" ");
        }
        return strBldr.toString().trim();

    }
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> hashMap = new TreeMap<>();
        Set<String> bannedSet = new HashSet<>();

        for (String s : banned) {
            bannedSet.add(s);
        }

        String[] punc = {"!", "\\?", "'", ";", ",", "\\."};
        Arrays.stream(paragraph.split(" ")).forEach(s -> {
            for (String s1 : punc) {
               s =  s.replaceAll(s1, "");
            }
            String s1 = s.toLowerCase();
            if (!bannedSet.contains(s1)) {
                hashMap.putIfAbsent(s1, 0);
                hashMap.put(s1, hashMap.get(s1) + 1);
            }
        });

        String max = "-";

        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            if (stringIntegerEntry.getValue() > hashMap.getOrDefault(max, Integer.MIN_VALUE)) {
                max = stringIntegerEntry.getKey();
            }
        }
        return max;

    }
}
