package codeforce;

import java.util.Scanner;

public class Solution1272A {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            solve(scanner.nextLine());
        }
    }

    private static void solve(String s) {
        String[] data = s.split(" ");


        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        int c = Integer.parseInt(data[2]);


        int ans = Math.abs(a - b) + Math.abs(a - c) + Math.abs(b - c);
        if(ans>=4){
           ans-=4;
        }else{
            ans-=2;
        }
        System.out.println(ans<0?0: ans);
    }
}
