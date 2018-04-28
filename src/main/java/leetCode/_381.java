package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gaurav on 28/04/18.
 */


public class _381 {


    class RandomizedCollection {

        ArrayList<Integer> nums;
        HashMap<Integer, List<Integer>> locs;
        java.util.Random rand = new java.util.Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {

            List<Integer> keys = locs.get(val);

            boolean contain = keys != null;
            if (contain) return false;

            if (keys == null) {
                keys = new ArrayList<>();
            }
            keys.add(nums.size());
            locs.put(val, keys);
            nums.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            List<Integer> keys = locs.get(val);

            boolean contain = keys != null;
            if (!contain) return false;
            int loc = keys.get(0);
            if (loc < nums.size() - 1) {
                int lastone = nums.get(nums.size() - 1);
                List<Integer> list = locs.get(lastone);
                Integer index = list.remove(0);
                list.add(loc);
                locs.put(lastone, list);
                nums.set(loc, lastone);

            }
            locs.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }


}
