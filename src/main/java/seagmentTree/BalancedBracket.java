package seagmentTree;

import template.InputReader;

import java.util.Stack;

/**
 * Created by Gaurav on 30/01/18.
 */
public class BalancedBracket {

    public static void main(String[] args) {
        InputReader inputReader
                = new InputReader(System.in);

        int n = inputReader.readInt();
        for (int j = 0; j < n; j++) {


            Stack<Character> stack = new Stack<>();

            boolean sta = false;
            String data = inputReader.readString();
            for (int i = 0; i < data.length(); i++) {
                char temp = data.charAt(i);
                if (temp == '}' || temp == ']' || temp == ')') {
                    Character poped = stack.pop();
                    boolean status = doesMatch(poped, temp);
                    if (status) {
                        sta = true;
                    } else {
                        break;
                    }
                } else {
                    stack.push(temp);
                }
            }
            if (sta) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }


    }

    private static boolean doesMatch(Character poped, char temp) {
        if (temp == '}') {
            return poped == '{';
        }
        if (temp == ']') {
            return poped == '[';
        }
        return poped == '(';
    }
}
