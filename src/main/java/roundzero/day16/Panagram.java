package roundzero.day16;

import java.util.Scanner;

public class Panagram {
    public static void main(String args[]) throws Exception {
           /* Enter your roundzero.code here. Read input from STDIN. Print output to STDOUT. Your class should be named CloudDay. */
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        solution(data);
    }

    private static void solution(String data) {

        int[] buffer = new int[26];

        for (int i = 0; i < data.length(); i++) {
            char dat = data.charAt(i);

            int index = getIndex(dat);
            if (index != -1) {
                buffer[index]++;
            }

        }
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == 0) {
                System.out.println("not pangram");
             return;
            }
        }
        System.out.println("pangram");
    }

    private static int getIndex(char dat) {
        if (dat >= 65 && dat <= 90) {
            return dat - 65;
        } else if (dat >= 97 && dat <= 122) {
            return dat - 97;

        } else {
            return -1;
        }

    }
}
