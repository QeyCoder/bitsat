package day65;

import java.util.*;

/**
 * Created by Gaurav on 09/04/18.
 */


public class TopFrequentWords {


    public static void main(String[] args) {

        TopFrequentWords topFrequentWords = new TopFrequentWords();
        topFrequentWords.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
                4);
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Integer op = stringIntegerMap.get(words[i]);
            if (op == null) {
                stringIntegerMap.put(words[i], 1);
            } else {
                stringIntegerMap.put(words[i], op + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()


        );
        for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerMap.entrySet()) {
            pq.add(stringIntegerEntry);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty()) {
            strings.add(pq.poll().getKey());
        }

        return strings;
    }


}
