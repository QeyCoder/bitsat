package day64;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaurav on 09/04/18.
 */


public class MagicDictionary {


    public static void main(String[] args) {
        System.out.println("gaurav".substring(2));
    }
    private final Trie tries;



    class Trie {


        public boolean search(String input) {


            TrieNode temp = root;
            for (int i = 0; i < input.length(); i++) {
                char inputChar = input.charAt(i);
                TrieNode op = temp.map.get(inputChar);
                if (op == null) {
                    return false;
                }
                //check all 26-1 combination by modifying the word
                temp = op;
            }
            return temp.isWord;
        }

        class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            boolean isWord = false;
        }

        private TrieNode root = new TrieNode();

        void insert(String input) {
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
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        tries = new Trie();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {

        for (int i = 0; i < dict.length; i++) {
            tries.insert(dict[i]);
        }

    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {

        return tries.search(word);

    }
}
