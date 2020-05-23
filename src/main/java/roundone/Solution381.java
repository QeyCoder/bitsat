package roundone;

import java.util.*;

public class Solution381 {
    static class RandomizedCollection {
        List<Integer> storage;
        Map<Integer, Set<Integer>> hash;
        Random random = new Random();
        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            storage = new ArrayList<>();
            hash = new HashMap<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean conta = hash.containsKey(val);
            if (!conta) hash.put(val, new HashSet<>());
            hash.get(val).add(storage.size());
            storage.add(val);
            return !conta;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
//        public boolean remove(int val) {
//            if (!hash.containsKey(val)) return false;
//            Set<Integer> indecies = hash.get(val);
//            Integer index = indecies.iterator().next();
//            hash.get(val).remove(index);
//            if (index < storage.size() - 1) { // not the last one than swap the last one with this val
//                Integer lastOne = storage.get(storage.size() - 1);
//                storage.set(index, lastOne);
//                hash.get(lastOne).remove(storage.size() - 1);
//                hash.get(lastOne).add(index);
//            }
//            storage.remove(storage.size() - 1);
//            if (hash.get(val).isEmpty()) hash.remove(index);
//            return true;
//        }

        public boolean remove(int val) {
            if (!hash.containsKey(val) || hash.get(val).size() == 0) return false;
            int remove_hash = hash.get(val).iterator().next();
            hash.get(val).remove(remove_hash);
            int last = storage.get(storage.size() - 1);
            storage.set(remove_hash, last);
            hash.get(last).add(remove_hash);
            hash.get(last).remove(storage.size() - 1);

            storage.remove(storage.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {

            return storage.get(random.nextInt(storage.size()));

        }
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedSet = new RandomizedCollection();
        randomizedSet.insert(1);
        randomizedSet.insert(1);
        randomizedSet.insert(2);

        System.out.println(randomizedSet.getRandom());

        randomizedSet.remove(1);
        System.out.println(randomizedSet.getRandom());
    }
}
