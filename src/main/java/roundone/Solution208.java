package roundone;

import day64.MagicDictionary;

import java.util.HashMap;
import java.util.Map;

public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // r
    }
    static class Trie {
        static class TrieNode {
            Map<Character, TrieNode> characterTrieMap = new HashMap<>();
            boolean isEnd;
        }

        /**
         * Initialize your data structure here.
         */
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String input) {
            TrieNode temp = root;
            for (int i = 0; i < input.length(); i++) {
                char inputChar = input.charAt(i);
                TrieNode op = temp.characterTrieMap.get(inputChar);
                if (op == null) {
                    op = new TrieNode();
                    temp.characterTrieMap.put(inputChar, op);
                }
                temp = op;

            }
            temp.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode temp =  root;
            for (int i = 0; i < word.length(); i++) {
                char input =  word.charAt(i);
                TrieNode node = temp.characterTrieMap.get(input);
                if(node==null){
                    return false;
                }
                temp=node;
            }
        return             temp==null?true:temp.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode temp =  root;
            for (int i = 0; i < prefix.length(); i++) {
                char input =  prefix.charAt(i);
                TrieNode node = temp.characterTrieMap.get(input);
                if(node==null){
                    return false;
                }
                temp=node;
            }
            return  temp!=null;
        }
    }
}
