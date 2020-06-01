package roundone;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {
    static class Solution {
        class Helper {
            int num;
            int frequency;

            public Helper(int key, int value) {
                this.num = key;
                this.frequency = value;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> storage = new HashMap<>();
            for (int num : nums) {
                if (storage.containsKey(num)) {
                    storage.put(num, storage.get(num) + 1);
                } else {
                    storage.put(num, 1);
                }
            }
            PriorityQueue<Helper> heap = new PriorityQueue<>(Comparator.comparingInt(o -> -o.frequency));
            for (Map.Entry<Integer, Integer> integerIntegerEntry : storage.entrySet()) {
                heap.add(new Helper(integerIntegerEntry.getKey(), integerIntegerEntry.getValue()));
            }

            int[] ints = new int[k];
            for (int i = 0; i < k; i++) {
                ints[i] = heap.poll().num;
            }
            return ints;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
