package roundone;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution5454 {

    static class Solution {

        class Helper{
            int i;
            int c;

            public Helper(int i, int c) {
                this.i = i;
                this.c = c;
            }
        }
        public int findLeastNumOfUniqueInts(int[] arr, int k) {

            PriorityQueue<Helper> integers =  new PriorityQueue<>(Comparator.comparingInt(o -> o.c));

            Map<Integer, Integer>  integerMap =  new HashMap<>();
            for (int i : arr) {
                integerMap.put(i, integerMap.getOrDefault(i,0)+1);
            }

            for (Map.Entry<Integer, Integer> integerIntegerEntry : integerMap.entrySet()) {
                integers.add(new Helper(integerIntegerEntry.getKey(),integerIntegerEntry.getValue()));
            }

            while (k-->0){
                Helper element = integers.poll();
                if(element.c>1){
                    element.c-=1;
                    integers.add(element);
                }
            }
            return integers.size();
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},3);
    }
}
