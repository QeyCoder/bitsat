package roundzero.seagmentTree;

import roundzero.template.FastInputReader;

import java.util.Stack;

/**
 * Created by Gaurav on 30/01/18.
 */
public class BalancedBracket {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader(System.in);

        int n = fastInputReader.readInt();
        for (int j = 0; j < n; j++) {


            Stack<Character> stack = new Stack<>();

            boolean sta = false;
            String data = fastInputReader.readString();
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
