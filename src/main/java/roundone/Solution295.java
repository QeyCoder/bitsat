package roundone;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution295 {
    static class MedianFinder {

        /**
         * initialize your data structure here.
         */
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        boolean even=true;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (even) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());

            }
            even = !even;
        }

        public double findMedian() {
            if (even) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return minHeap.peek();
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String args[]) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}
