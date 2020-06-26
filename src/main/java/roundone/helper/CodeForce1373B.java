package roundone.helper;

import java.util.Scanner;

public class CodeForce1373B {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            solve(scanner.nextLine());
        }
    }

    private static void solve(String s) {

        int one = 0, zero = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                one++;
            } else {
                zero++;
            }
        }
        boolean da=false;
        if(one == zero){
            if(one%2!=0){
                da= true;
            }
        }else{
            if(Math.min(one, zero) % 2 != 0){
                da=true;
            }
        }
        System.out.println(da?"DA":"NET");
    }
}
