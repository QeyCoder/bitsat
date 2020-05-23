package roundone;

import java.util.*;

public class Solution380 {
    static class RandomizedSet {
        List<Integer> storage;
        Map<Integer, Integer> hash;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            storage = new ArrayList<>();
            hash = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (hash.containsKey(val)) {
                return false;
            }
            storage.add(val);
            hash.put(val, storage.size() - 1);
            return true;

        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!hash.containsKey(val)) {
                return false;
            }
            int index = hash.get(val);
            if (index < storage.size() - 1) { // not the last one than swap the last one with this val
                int lastone = storage.get(storage.size() - 1);
                storage.set(index, lastone);
                hash.put(lastone, index);
            }
            hash.remove(val);
            storage.remove(storage.size() - 1);
            return true;


        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random random = new Random();
            return storage.get(random.nextInt(storage.size()));

        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        System.out.println(randomizedSet.getRandom());

        randomizedSet.remove(0);
        randomizedSet.insert(0);
    }
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
