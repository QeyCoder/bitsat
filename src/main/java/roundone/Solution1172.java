package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1172 {
    static class DinnerPlates {
        List<List<Integer>> stack = new ArrayList<>();
        int capacity = 0;
        int index = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {


            if (heap.size() != 0) {
                Integer stackIndex = heap.peek();
                stack.get(stackIndex).add(val);
                if (stack.get(stackIndex).size() / capacity == 1) {
                    heap.remove();
                }
                return;
            }

            List<Integer> leftMostStack;
            if (stack.size() == index) {
                stack.add(index, new ArrayList<>());
            }
            leftMostStack = stack.get(index);
            if (leftMostStack == null) {
                leftMostStack = new ArrayList<>();
            }

            if (leftMostStack.size() / capacity == 1) {
                index++;
                push(val);
                return;
            }
            leftMostStack.add(val);
            if (leftMostStack.size() == capacity) {
                index++;
            }
        }

        public int pop() {
            if (index < 0) {
                return -1;
            }
            List<Integer> currStack = stack.get(index);
            if (currStack.size() != 0) {
                Integer element = currStack.remove(currStack.size() - 1);
                if (currStack.size() == 0) {
                    heap.add(index);
                }
                return element;
            }
            index--;
            return pop();
        }

        public int popAtStack(int ipIndex) {
            if (ipIndex > index) {
                return -1;
            }
            List<Integer> currentStack = stack.get(ipIndex);

            if (currentStack.size() != 0) {
                Integer item = currentStack.remove(currentStack.size() - 1);
                heap.add(ipIndex);
                return item;
            }
            return -1;

        }
    }

    /**
     * Your DinnerPlates object will be instantiated and called as such:
     * DinnerPlates obj = new DinnerPlates(capacity);
     * obj.push(val);
     * int param_2 = obj.pop();
     * int param_3 = obj.popAtStack(index);
     */

    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(1);  // Initialize with capacity = 2
//        ["DinnerPlates","push","push","popAtStack","pop","push","push","pop","pop"]
//        [[1],[1],[2],[1],[],[1],[2],[],[]]
        D.push(1);
        D.push(2);
        D.popAtStack(1);
        D.pop();
        D.push(1);
        D.push(2);
        D.pop();
        D.pop();
    }

}
