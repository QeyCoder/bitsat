package roundone;

import roundone.helper.tries.TrieNode;

import java.util.Stack;

public class Solution720 {

    static class Solution {
        TrieNode<Character> root = new TrieNode();

        public String longestWord(String[] words) {
            for (int i = 0; i < words.length; i++) {
                insert(words[i]);
            }
            return ans(root);
        }

        private String ans(TrieNode<Character> root) {
            Stack<TrieNode> stack = new Stack<>();
            stack.add(root);

            while (!stack.isEmpty()){

            }
            return "";
        }

        private void insert(String words) {

            TrieNode trie = root;

            for (int i = 0; i < words.length(); i++) {
                char character = words.charAt(i);
                TrieNode element = (TrieNode) trie.getCharMap().get(character);
                if (element == null) {
                    element = new TrieNode();
                    trie.getCharMap().put(character, element);
                }
                trie = element;
            }
            trie.setEnd(true);
        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
    }
}
