package roundone;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CodeForce1374C {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            scanner.nextLine();
            solve(scanner.nextLine());
        }
    }

    private static void solve(String s) {
        Stack<Character> dl = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (!dl.isEmpty()) {
                    Character element = dl.peek();
                    if (element == '(') {
                        dl.pop();
                    } else {
                        dl.push(element);
                    }
                }else {
                    dl.push(ch);
                }
            }else{
                dl.push(ch);
            }
        }
        System.out.println(dl.size() / 2);


    }
}
