package roundone;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode225 {
    class MyStack {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.add(x);

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(queue1.size()!=1){
                queue2.add(queue1.poll());
            }
            int element = queue1.poll();
            Queue<Integer> tmp = queue1;
            queue1= queue2;
            queue2= tmp;
            return element;
        }

        /** Get the top element. */
        public int top() {
            while(queue1.size()!=1){
                queue2.add(queue1.poll());
            }
            int element = queue1.poll();
            queue2.add(element);
            Queue<Integer> tmp = queue1;
            queue1= queue2;
            queue2= tmp;
            return element;

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.size()==0;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
