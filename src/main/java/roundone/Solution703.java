package roundone;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution703

{


    static class KthLargest {

        private final int k;
        private PriorityQueue<Integer> heap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
            for (int integer : nums) {
                heap.add(integer);
            }

        }

        public int add(int n) {

            if (heap.size() < k)
                heap.offer(n);
            else if (heap.peek() < n) {
                heap.poll();
                heap.offer(n);
            }
            return heap.peek();
        }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
    }

    public static void main(String args[]) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }
}
