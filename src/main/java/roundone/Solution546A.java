package roundone;

import java.util.Scanner;

public class Solution546A {


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] ip = scanner.nextLine().split(" ");

        int price= Integer.parseInt(ip[0]);
        int amnt= Integer.parseInt(ip[1]);
        int k = Integer.parseInt(ip[2]);

        int sum=0;
        int i=1;
        while (i<=k){
            sum+= price*i;
            i++;
        }

        int ans = sum - amnt;
        System.out.println(ans>0?ans:0);

    }
}
