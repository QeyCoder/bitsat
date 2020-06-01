package roundone;

import java.util.*;

public class Solution692 {

    static class Solution {
        class Helper {
            String word;
            int frequecy;

            public Helper(String key, Integer value) {
                this.word = key;
                this.frequecy = value;
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> storage = new HashMap<>();
            for (String num : words) {
                storage.put(num, storage.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Helper> heap = new PriorityQueue<>((o1, o2) -> {
                if (o1.frequecy == o2.frequecy) {
                    return o1.word.compareTo(o2.word);
                } else {
                    return o2.frequecy - o1.frequecy;
                }
            });
            for (Map.Entry<String, Integer> integerIntegerEntry : storage.entrySet()) {
                heap.add(new Helper(integerIntegerEntry.getKey(), integerIntegerEntry.getValue()));
            }

            List<String> ints = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                ints.add(heap.poll().word);
            }
            return ints;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
