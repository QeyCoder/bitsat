package roundzero.day123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://www.interviewbit.com/problems/nearest-smaller-element/?ref=similar_problems
public class StackWithPrevSmall {
    public ArrayList<Integer> prevSmaller(List<Integer> arr) {

        Stack<Integer> stack = new Stack();
        stack.push(arr.get(0));

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            while (!stack.empty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                integers.add(-1);
            } else {
                integers.add(stack.peek());
            }
            stack.push(arr.get(i));

        }
        return integers;

    }

    public static void main(String[] args) {
        StackWithPrevSmall solution2 = new StackWithPrevSmall();
        List<Integer> list = Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28);
        System.out.println(solution2.prevSmaller(list));

    }
}
