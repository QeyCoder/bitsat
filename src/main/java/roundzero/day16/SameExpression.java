package roundzero.day16;

import java.util.Scanner;

/**
 * Created by Gaurav on 08/11/17.
 */
//http://www.geeksforgeeks.org/check-two-expressions-brackets/
public class SameExpression {

    public static void main(String[] args) {


        Scanner scanner
                = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCase; i++) {
            System.out.println(solution(scanner.nextLine(), scanner.nextLine()));
        }

    }

    private static String solution(String withParanath, String b) {

        boolean reverse = false;
        StringBuilder stringBuilder =  new StringBuilder();
        for (int i = 0; i < withParanath.length(); i++) {

            char ipChar = withParanath.charAt(i);
            if (i>0&& ipChar == '(' && withParanath.charAt(i-1)=='-'){
                reverse = true;
            }else if(ipChar == ')'){
                reverse =  false;
            }else {
                if (reverse) {
                    if (ipChar == '-') {
                        ipChar = '+';
                    } else if (ipChar == '+') {
                        ipChar = '-';
                    } else if (ipChar == '*') {
                        ipChar = '/';
                    } else if (ipChar == '/') {
                        ipChar = '*';
                    }
                }
                stringBuilder.append(ipChar);
            }



        }
        if(stringBuilder.toString() ==  b){
            return "YES";
        }else{
            return "NO";
        }

    }
}
