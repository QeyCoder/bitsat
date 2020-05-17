package day64;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaurav on 08/04/18.
 */

//https://leetcode.com/problems/map-sum-pairs/description/
public class MapSum {
    Trie trie;

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("apple"));
        // mapSum.insert("app", 2);
        //System.out.println(mapSum.sum("ap"));
    }

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.getSum(prefix);
    }

    class Trie {
        public int getSum(String prefix) {


            TrieNode temp = root;

            for (int i = 0; i < prefix.length(); i++) {
                char inputChar = prefix.charAt(i);
                TrieNode op = temp.map.get(inputChar);
                if (op == null) {
                    return 0;
                } else {
                    temp = op;
                }
            }
            return getSumHere(temp);

        }

        private int getSumHere(TrieNode temp) {
            if (temp == null) {
                return 0;
            }

            int sum = 0;
            boolean running = true;
            for (TrieNode trieNode : temp.map.values()) {
                sum += trieNode.sum + getSumHere(trieNode);
            }
            return sum;
        }

        class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            int sum = 0;
        }

        TrieNode root = new TrieNode();

        void insert(String input, int val) {
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
            temp.sum = val;
        }
    }

}
