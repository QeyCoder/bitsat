package roundone;

public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.startsWith("app");
        trie.insert("hello");
        trie.search("hell");   // returns true
        trie.search("helloa");   // returns true
//        trie.search("app");     // returns false
//        trie.startsWith("app"); // returns true
//        trie.insert("app");
//        trie.search("app");     // r
    }

    static class Trie {




        class TrieNode{
            TrieNode[] nodes= new TrieNode[26];
            boolean isEnd;

        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root= new TrieNode();

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {


            TrieNode tmp = root;
            for(int i=0; i< word.length(); i++){
                int index= word.charAt(i)-'a';
                if(tmp.nodes[index]!=null){
                    tmp= tmp.nodes[index];
                }else{
                    tmp.nodes[index]=new TrieNode();
                     tmp= tmp.nodes[index];
                }
            }

            tmp.isEnd = true;
        }


        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode tmp =  root;


            for (int i = 0; i < word.length(); i++) {
                int ch =  word.charAt(i)-'a';
                if(tmp.nodes[ch]!=null){
                    tmp= tmp.nodes[ch];
                }else{
                    return false;
                }
            }
            return  tmp.isEnd==true;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

            TrieNode tmp =  root;


            for (int i = 0; i < prefix.length(); i++) {
                int ch =  prefix.charAt(i)-'a';
                if(tmp.nodes[ch]!=null){
                    tmp= tmp.nodes[ch];
                }else {
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//    static class Trie {
//        static class TrieNode {
//            Map<Character, TrieNode> characterTrieMap = new HashMap<>();
//            boolean isEnd;
//        }
//
//        /**
//         * Initialize your data structure here.
//         */
//        TrieNode root;
//
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        /**
//         * Inserts a word into the trie.
//         */
//        public void insert(String input) {
//            TrieNode temp = root;
//            for (int i = 0; i < input.length(); i++) {
//                char inputChar = input.charAt(i);
//                TrieNode op = temp.characterTrieMap.get(inputChar);
//                if (op == null) {
//                    op = new TrieNode();
//                    temp.characterTrieMap.put(inputChar, op);
//                }
//                temp = op;
//
//            }
//            temp.isEnd = true;
//        }
//
//        /**
//         * Returns if the word is in the trie.
//         */
//        public boolean search(String word) {
//            TrieNode temp =  root;
//            for (int i = 0; i < word.length(); i++) {
//                char input =  word.charAt(i);
//                TrieNode node = temp.characterTrieMap.get(input);
//                if(node==null){
//                    return false;
//                }
//                temp=node;
//            }
//        return             temp==null?true:temp.isEnd;
//        }
//
//        /**
//         * Returns if there is any word in the trie that starts with the given prefix.
//         */
//        public boolean startsWith(String prefix) {
//            TrieNode temp =  root;
//            for (int i = 0; i < prefix.length(); i++) {
//                char input =  prefix.charAt(i);
//                TrieNode node = temp.characterTrieMap.get(input);
//                if(node==null){
//                    return false;
//                }
//                temp=node;
//            }
//            return  temp!=null;
//        }
//    }
}
