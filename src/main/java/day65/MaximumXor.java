package day65;


/**
 * Created by Gaurav on 09/04/18.
 */


public class MaximumXor {


    public static void main(String[] args) {
        MaximumXor maximumXor = new MaximumXor();
        //  System.out.println(maximumXor.findMaximumXOR(new int[]{42, 5, 69, 22, 23, 8, 1, 17, 30, 75, 99}));
        System.out.println(maximumXor.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int val : nums) {
            trie.insert(val);
        }
        return (int) trie.count(nums);

    }

    public class Trie {

        TrieNode root = new TrieNode();

        public void insert(int val) {
            TrieNode current = root;

            for (int i = 31; i >= 0; i--) {

                int bit = (val >> i) & 1;

                if (bit == 0) {
                    if (current.left == null) {
                        current.left = new TrieNode();
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new TrieNode();
                    }
                    current = current.right;
                }

            }


        }

        public long count(int[] nums) {

            long max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                TrieNode current = root;
                long currentMax = 0;
                int val = nums[i];
                for (int j = 31; j >= 0; j--) {

                    int bit = (val >> j) & 1;

                    if (bit == 0) {
                        if (current.right != null) {
                            currentMax += (1l << j);
                            current = current.right;
                        } else {
                            current = current.left;

                        }
                    } else {
                        if (current.left != null) {
                            currentMax += (1l << j);
                            current = current.left;
                        } else {
                            current = current.right;
                        }
                    }

                }

                if (currentMax > max) {
                    max = currentMax;
                }
            }
            return max;
        }


        class TrieNode {

            TrieNode left;
            TrieNode right;

        }
    }
}
