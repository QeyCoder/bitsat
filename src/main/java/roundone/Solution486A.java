package roundone;

import java.util.Scanner;

public class Solution486A {


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(solve(Long.parseLong(scanner.nextLine())));
    }

    private static long solve(long no) {
       if(no%2==0){
           return no/2;
       }else{
           return -1*(no+1)/2;
       }

    }
}
