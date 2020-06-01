package roundone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution215 {

    static class Solution {
        //heap way
        public int findKthLargestHeap(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o));

            for (int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
            }
            for (int i = 0; i < k-1; i++) {
                heap.poll();
            }
            return heap.poll();

        }
        //heap way
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-1-k];

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
