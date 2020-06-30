package roundone;

import java.util.HashMap;
import java.util.Map;

public class Solution677 {
    static class MapSum {

        private Map<String, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {

            int sum = 0;
            for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                String key = stringIntegerEntry.getKey();

                int index = key.indexOf(prefix);
                if (index == 0) {
                    sum += stringIntegerEntry.getValue();
                }

            }

            return sum;

        }
    }


    public static void main(String[] args) {
        MapSum mapSum
                 = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");
        mapSum. insert("app", 2);
        mapSum.sum("ap");
    }
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
