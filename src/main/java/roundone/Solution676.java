package roundone;

import java.util.HashMap;
import java.util.Map;

public class Solution676 {
    static class MagicDictionary {

        static class TrieNode {
            boolean isEnd;
            Map<Character, TrieNode> charMap = new HashMap<>();

        }

        /**
         * Initialize your data structure here.
         */
        TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String word : dict) {
                insert(word);
            }
        }

        private void insert(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                Character character = word.charAt(i);
                TrieNode node = temp.charMap.get(character);
                if (node == null) {
                    node = new TrieNode();
                    temp.charMap.put(character, node);
                }
                temp = node;
            }
            temp.isEnd = true;

        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            int modified =0;
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                Character character = word.charAt(i);
                TrieNode node = temp.charMap.get(character);
                if(node==null){
                    for (Map.Entry<Character,TrieNode> characterTrieNodeEntry : node.charMap.entrySet()) {
                        TrieNode item = characterTrieNodeEntry.getValue().charMap.get(character);

                    }
                    modified++;
                }
            }
            return  modified==1;
        }
    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */

    public static void main(String args[]) {
        MagicDictionary solution = new MagicDictionary();

        solution.buildDict(new String[]{"hello", "leetcode"});
        solution.search("hello");
        solution.search("hhllo");
        solution.search("hell");
        solution.search("leetcoded");

    }
}
