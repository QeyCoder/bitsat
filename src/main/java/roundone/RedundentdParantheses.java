package roundone;

import java.util.Scanner;
import java.util.Stack;

public class RedundentdParantheses {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            solve(scanner.nextLine());
        }
    }

    private static void solve(String ip) {
        char[] arr = ip.toCharArray();

        Stack<Character> characterStack = new Stack<>();
        for (char c : arr) {
            if (c == ')') {
                Character element = characterStack.peek();
                characterStack.pop();
                boolean invalid = true;
                while (element != '(') {
                    if (element == '+' || element == '-' || element == '*' || element == '/') {
                        invalid = false;
                    }
                    element = characterStack.pop();
                }
                if (invalid) {
                    System.out.println("Invalid");
                    return;
                }
            } else {
                characterStack.add(c);
            }
        }
        System.out.println("Valid");
    }
}
