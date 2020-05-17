package day65;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gaurav on 09/04/18.
 */


public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {

        Trie tries = new Trie();
        for (int i = 0; i < dict.size(); i++) {
            tries.insert(dict.get(i));
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[] spltd = sentence.split(" ");
        for (int i = 0; i < spltd.length; i++) {
            stringBuilder.append(tries.getSucessor(spltd[i])).append(" ");
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        System.out.println(replaceWords.replaceWords(Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa"}),
                "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));

    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String input) {

            TrieNode current = root;

            for (int i = 0; i < input.length(); i++) {
                char inputChar = input.charAt(i);
                TrieNode op = current.map.get(inputChar);
                if (op == null) {
                    op = new TrieNode();
                    current.map.put(inputChar, op);
                }
                current = op;
            }
            current.isEnd = true;
        }

        public String getSucessor(String input) {
            TrieNode temp = root;
            StringBuilder wordFormerd = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char inputChar = input.charAt(i);
                TrieNode op = temp.map.get(inputChar);
                if (op != null) {
                    wordFormerd.append(inputChar);
                }
                if (op == null && temp.isEnd == true) {

                    return wordFormerd.toString().trim();

                }
                if (op == null) {
                    return input;
                }
                if (op.isEnd == true) {
                    return wordFormerd.toString().trim();
                }
                temp = op;
            }
            return input;
        }

        class TrieNode {

            Map<Character, TrieNode> map = new HashMap<>();
            boolean isEnd = false;


        }
    }


}
