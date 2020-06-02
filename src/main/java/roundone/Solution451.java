package roundone;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {

    static class Solution {
        class Helper {
            char word;
            int frequecy;

            public Helper(char key, Integer value) {
                this.word = key;
                this.frequecy = value;
            }
        }
        public String frequencySort(String word) {
            Map<Character, Integer> storage = new HashMap<>();
            for (char num : word.toCharArray()) {
                storage.put(num, storage.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Helper> heap = new PriorityQueue<>((o1, o2) -> {
                if (o1.frequecy == o2.frequecy) {
                    return o2.word-o2.word;
                } else {
                    return o2.frequecy - o1.frequecy;
                }
            });

            for (Map.Entry<Character, Integer> integerIntegerEntry : storage.entrySet()) {
                heap.add(new Helper(integerIntegerEntry.getKey(), integerIntegerEntry.getValue()));
            }

            StringBuilder stringBuilder =  new StringBuilder();
            while(!heap.isEmpty()){
                Helper element = heap.poll();
                for (int i = 0; i < element.frequecy; i++) {

                    stringBuilder.append(element.word);
                }
            }
            return stringBuilder.toString();
        }
    }
    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
