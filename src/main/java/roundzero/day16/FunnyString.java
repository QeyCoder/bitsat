package roundzero.day16;

import java.util.Scanner;

public class FunnyString {

    static String funnyString(String s) {
        int len;
        if(s.length()%2 == 0 ){
            len =  s.length()/2;
        }else{
            len =  s.length()/2+1;
        }
        for (int i = 1; i <len; i++) {
            if (s.charAt(i) - s.charAt(i - 1) != s.charAt(s.length() - i-1) - s.charAt(s.length() - i+1-2)) {

                return "Not Funny";
            }

        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
