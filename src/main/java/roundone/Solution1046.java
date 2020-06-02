package roundone;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution1046 {
    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

            for (int stone : stones) {
                heap.add(stone);
            }

            while (heap.size() > 1) {
                Integer stone1 = heap.poll();
                Integer stone2 = heap.poll();

                if (stone1 == stone2) {
                    continue;
                } else {
                    stone1 -= stone2;
                    heap.add(stone1);
                }
            }

            if (heap.size() == 0) {
               return 0;
            } else {
                return heap.poll();
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.lastStoneWeight(new int[]{2,7,4,1,8,1,1});
    }
}
