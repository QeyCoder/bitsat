package leetCode;

import java.util.*;

/**
 * Created by Gaurav on 28/04/18.
 */


public class _380 {


    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */


    static class RandomizedSet {


        Random rand = new Random();
        Map<Integer, Integer> integerMap;
        List<Integer> list;


        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            integerMap = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = integerMap.containsKey(val);
            if (contain) return false;
            integerMap.put(val, list.size());
            list.add(val);
            return true;
        }


        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = integerMap.containsKey(val);
            if ( ! contain ) return false;
            int loc = integerMap.get(val);
            if (loc < list.size() - 1 ) { // not the last one than swap the last one with this val
                int lastone = integerMap.get(list.size() - 1 );
                list.set( loc , lastone );
                integerMap.put(lastone, loc);
            }
            integerMap.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        /**
         * Get a random element from the set.
         */

        public int getRandom() {
            //return list.get(rand.nextInt(list.size()));
            return list.get(rand.nextInt(list.size()));
        }


    }


    public static void main(String[] args) {
        /**
         * ["RandomizedSet","insert","insert","remove"
         * ,"insert","insert","insert",
         * "remove","remove",
         * "insert","remove","insert",
         * "insert","insert","insert",
         * "insert","getRandom","insert",
         * "remove","insert","insert"]
         [[],
         [3],[-2],[2],
         [1],[-3],[-2],
         [-2],[3],
         [-1],[-3],[1],
         [-2],[-2],[-2],
         [1],[],[-2],
         [0],[-3],[1]]
         */

        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(3);
        randomizedSet.insert(-2);
        randomizedSet.remove(2);
        randomizedSet.insert(1);
        randomizedSet.insert(-3);
        randomizedSet.insert(-2);
        randomizedSet.remove(-2);
        randomizedSet.remove(3);
        randomizedSet.insert(-1);
        randomizedSet.remove(-3);
        randomizedSet.insert(1);
        randomizedSet.insert(-2);
        randomizedSet.insert(-2);
        randomizedSet.insert(-2);
        randomizedSet.insert(1);
        randomizedSet.getRandom();
        randomizedSet.insert(-2);
        randomizedSet.remove(0);
        randomizedSet.insert(-3);
        randomizedSet.insert(1);
    }


}