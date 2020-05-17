package roundzero.day16;

import java.util.Scanner;

public class Password {

    static int minimumNumber(int n, String password) {

        int uppercase = 0;
        int lowecase = 0;
        int digit = 0;
        int special = 0;
        int totalchar = 0;


        for (int i = 0; i < password.length(); i++) {

            char inputChar = password.charAt(i);


            if (inputChar >= 65 && inputChar <= 90) {
                uppercase++;
            } else if (inputChar >= 97 && inputChar <= 122) {
                lowecase++;
            } else if (inputChar >= 48 && inputChar <= 57) {
                digit++;
            } else if (inputChar >= 32 && inputChar <= 47) {
                special++;
            }
        }
        if (special < 1) {
            totalchar++;
        }
        if (lowecase < 1) {
            totalchar++;
        }
        if (uppercase < 1) {
            totalchar++;
        }
        if (digit < 1) {
            totalchar++;
        }
        if (n < 6) {
            int newlength = 6 - n;

            if (newlength > totalchar) {
                totalchar = newlength;
            }
        }
        return totalchar;
        // Return the minimum number of characters to make the password strong
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
