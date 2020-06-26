package roundone.helper;

import java.util.Scanner;

public class COdeforce1373A {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            solve(scanner.nextLine());
        }
    }

    private static void solve(String s) {
        String[] ip = s.split(" ");
        long a = Long.parseLong(ip[0]);
        long b = Long.parseLong(ip[1]);
        long c = Long.parseLong(ip[2]);
        long ans1=-1,ans2=-1;
        if (a<c) {
            ans1=1;
        }
        if((a*b)>c){
            ans2= b;
        }
        System.out.println(ans1+" "+ ans2);
    }
}
