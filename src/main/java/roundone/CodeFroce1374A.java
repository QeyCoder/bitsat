package roundone;

import java.util.Scanner;

public class CodeFroce1374A {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            solve(scanner.nextLine());
        }
    }

    private static void solve(String s) {

        String[] ip = s.split(" ");
        int x = Integer.parseInt(ip[0]);
        int y = Integer.parseInt(ip[1]);
        int z = Integer.parseInt(ip[2]);



        int a= z/x;
        int b =  a*x+y;

        if(b>z){
            b-=x;
        }
        System.out.println(b);



    }
}
