package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _575 {


    static class Solution {
        public int distributeCandies(int[] candies) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < candies.length; i++) {
                int key = candies[i];
                Integer value = map.get(key);
                if (value == null) {
                    value = 0;
                }
                map.put(key, ++value);
            }
            int val = map.size();
            int unique = 0;
            for (Integer integer : map.values()) {
                if (integer == 1) {
                    unique++;
                }
            }
            int kind = map.size();
            int total = candies.length / 2;

            int pending = total - unique;

            if (total >= kind) {
                return kind;
            } else {
                return total;

            }

        }
    }

    public static void main(String[] args) {
        Solution solution
                = new Solution();
        solution.distributeCandies(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8});
    }


}
