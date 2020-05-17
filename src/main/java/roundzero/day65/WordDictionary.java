package day65;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaurav on 09/04/18.
 */


public class WordDictionary {

    public WordDictionary() {
        tries = new Trie();
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.tries.addWord("bad");
        wordDictionary.tries.addWord("dad");
        wordDictionary.tries.addWord("mad");
       // System.out.println(wordDictionary.tries.search("pad"));
        //System.out.println(wordDictionary.tries.search("bad"));
        System.out.println(wordDictionary.tries.search(".ad"));
        System.out.println(wordDictionary.tries.search("b.."));
    }

    private final Trie tries;


    class Trie {
        public boolean search(String input) {
            TrieNode temp = root;
            return search(input.toCharArray(), 0, temp);
        }

        private boolean search(char[] input, int index, TrieNode temp) {


            if (index == input.length) {
                if (temp.isWord) {
                    return true;
                }
                return false;
            }

            char inputChar = input[index];
            Collection<TrieNode> nodes = temp.map.values();
            if (inputChar == '.') {

                for (TrieNode node : nodes) {
                    if (node != null) {
                        boolean ans = search(input, index + 1, node);
                        if (ans) {
                            return true;
                        }
                    }
                }
                return false;
            }
            TrieNode op = temp.map.get(inputChar);
            if (op == null) {
                return false;
            }
            return search(input, ++index, op);
        }

        class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            boolean isWord = false;
        }

        private TrieNode root = new TrieNode();

        void addWord(String input) {
            TrieNode temp = root;
            for (int i = 0; i < input.length(); i++) {
                char inputChar = input.charAt(i);
                TrieNode op = temp.map.get(inputChar);
                if (op == null) {
                    op = new TrieNode();
                    temp.map.put(inputChar, op);
                }
                temp = op;
            }
            temp.isWord = true;
        }
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        tries.addWord(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return tries.search(word);
    }


}
