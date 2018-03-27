package flipkart;

import java.util.*;

/**
 * Created by Gaurav on 22/03/18.
 */


public class Election {


    public static void main(String[] args) {
      /*  FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        String[] ip = new String[N];
        for (int i = 0; i < N; i++) {
            ip[i] = fastInputReader.readString();
        }
        System.out.println(electionWinner(ip));*/
        findSubstrings("aba");
        //findSubstrings("aab");
    }

    static String electionWinner(String[] votes) {
        Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < votes.length; i++) {
            Integer person = map.get(votes[i]);
            if (person != null && person != 0) {
                map.put(votes[i], person + 1);
            } else {
                map.put(votes[i], 1);
            }
        }


        Map.Entry<String, Integer> val = Collections.max(map.entrySet(), Map.Entry.comparingByValue());

        return val.getKey();
    }

    static void findSubstrings(String s) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isInputVowel(s.charAt(i))) {
                for (int j = i ; j < s.length(); j++) {
                    if (!isInputVowel(s.charAt(j))) {
                        strings.add(s.substring(i, j + 1));
                    }
                }
            }
        }

        Collections.sort(strings);

            System.out.println(strings.get(0));
        System.out.println(strings.get(strings.size()-1));



    }

    private static boolean isInputVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
