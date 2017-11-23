package day16;

import java.util.Scanner;

public class Solution {

    static int solveMeFirst(int a, int b) {
         // Hint: Type return a+b; below 
return a+b;
   }
    static int simpleArraySum(int n, int[] ar) {
        
        int sum =  ar[0];
        for (int i = 1; i <ar.length ; i++) {
            sum+=ar[i];
        }
        return sum;
        // Complete this function
    }
   
 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
   }
}
