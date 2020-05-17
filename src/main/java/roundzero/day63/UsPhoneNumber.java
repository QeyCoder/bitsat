package day63;

/**
 * Created by Gaurav on 02/04/18.
 */


public class UsPhoneNumber {


    public static void main(String[] args) {
        String[] ip = {"xxx999-999-9999"};
        //      String[] ip = {"xxx (123) 123-1234", "(123) 123-1234", "(123) 123 -1234", "123-456-7890", "23", "xxxxxxxxxxx", "123-xx123-2322", "(000) 000-0000111", "xxx999-999-9999", "123-456-7890", "1234567890"};
        for (int i = 0; i < ip.length; i++) {
            System.out.println(solution(ip[i]));
        }

    }

    private static String solution(String s) {
        if (s.length() < 10) {
            return "NONE";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int numCount = 0;


        while (i < s.length()) {
            int ip = s.charAt(i++) - '0';
            if (ip == -8 || ip == -7 || ip == -3) {
                i--;
                break;
            }
            if (ip <= 0 && ip >= 9) {

            } else {
                i--;
                break;
            }

        }
        while (i < s.length()) {
            if (numCount == 10) {
                break;
            }
            char ip = s.charAt(i);

            if (ip == '-' || ip == '(' || ip == ')' || ip == ' ') {
                stringBuilder.append(ip);
            }
            ip -= '0';

            if (ip >= 0 && ip <= 9) {
                numCount++;
                stringBuilder.append((int) ip);
            }
            i++;
        }
        String op = stringBuilder.toString();
        if (op.matches("\\d{3}-\\d{3}-\\d{4}") || op.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}")) {
            return op;
        }

        return "NONE";
    }


}
