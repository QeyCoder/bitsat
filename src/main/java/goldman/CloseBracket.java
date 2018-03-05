package goldman;

import java.util.Stack;

/**
 * Created by Gaurav on 04/03/18.
 */


public class CloseBracket {


    public static void main(String[] args) {
        System.out.println(closingBracePosition("()()", 2));

        System.out.println(closingBracePosition("(I want (to write a language parser), would (you) help me)", 2));
        System.out.println(closingBracePosition("(((((((((())))))))))", 1));
        System.out.println(closingBracePosition("(This)is an (error)as it has (extra opening)(parantxheses)  ", 2));
        System.out.println(closingBracePosition("(This ){is an (error)as it has (extra opening)(parantheses  ", 2));
    }

    static int closingBracePosition(String inputSentence, int openingBraceNum) {
        if (openingBraceNum == 0) {
            return 0;
        }

        Pair result = checkForValid(inputSentence);
        if (!result.invalid) {


            Stack<Character> characters = new Stack<>();
            int require =  result.open-openingBraceNum;
            for (int i = 0; i < inputSentence.length(); i++) {
                char ip = inputSentence.charAt(i);
                if (ip == '(') {
                    result.open--;
                } else if (ip == ')') {
                    result.close--;
                }
                if (result.close == require) {
                    return i + 1;
                }
            }

        }

        return -1;

    }

    /*static int closingBracePosition(String inputSentence, int openingBraceNum) {


        if (checkForValid(inputSentence)) {
            int count = 0;

            Stack<Character> characters = new Stack<>();
            for (int i = 0; i < inputSentence.length(); i++) {
                char ip = inputSentence.charAt(i);
                if ((ip == '(' || ip == '{' || ip == '[') && openingBraceNum != 0) {
                    characters.push(ip);
                    openingBraceNum--;
                } else if ((ip == ')' || ip == '}' || ip == ']')) {
                    if (characters.empty()) {
                        return -1;
                    }
                    Character op = characters.peek();

                    if ((ip == ')' && op == '(') || (ip == '}' && op == '{') || (ip == ']' && op == '[') && openingBraceNum == 0) {
                        return i + 1;
                    } else if ((ip == ')' && op == '(') || (ip == '}' && op == '{') || (ip == ']' && op == '[') && openingBraceNum == 0) {
                        return characters.pop();
                    } else if ((ip == ')' && op != '(') || (ip == '}' && op != '{') || (ip == ']' && op != '[') && openingBraceNum == 0) {
                        return -1;
                    }
                }
            }
            if (characters.size() > 0 || openingBraceNum > 0) {
                return -1;
            }
            return count;
        }
        return -1;
    }*/


    static class Pair {
        int open = -1;
        int close = -1;
        boolean invalid = true;
    }

    private static Pair checkForValid(String inputSentence) {

        int open = 0;
        int close = 0;


        Stack<Character> characters = new Stack<>();


        for (int i = 0; i < inputSentence.length(); i++) {
            char ip = inputSentence.charAt(i);
            if ((ip == '(')) {
                open++;
                characters.push(ip);
            } else if ((ip == ')')) {
                close++;
                if (characters.empty()) {
                    return new Pair();
                }
                Character op = characters.peek();
                if ((ip == ')' && op == '(') || (ip == '}' && op == '{') || (ip == ']' && op == '[')) {
                    characters.pop();
                } else {
                    return new Pair();
                }
            }
        }
        if (characters.size() > 0) {
            return new Pair();
        }
        Pair p = new Pair();
        p.open = open;
        p.close = close;
        p.invalid = false;
        return p;
    }

}
