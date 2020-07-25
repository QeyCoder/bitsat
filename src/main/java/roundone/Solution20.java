package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution20 {


    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            List<Character> open = new ArrayList<>();
            List<Character> close = new ArrayList<>();

            open.add('{');
            open.add('(');
            open.add('[');

            close.add('}');
            close.add(')');
            close.add(']');


            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (open.contains(c)) {
                    stack.add(c);
                } else {
                    if (!stack.isEmpty()) {

                        Character item = stack.pop();

                        if (c == '}' && item == '{' || c == ')' && item == '(' || c == ']' && item == '[') {
                            continue;
                        }
                        return false;

                    }
                    return false;
                }
            }
            return stack.size() == 0;

        }
    }
}



