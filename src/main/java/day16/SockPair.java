package day16;

import java.util.Scanner;

public class SockPair {

    static int sockMerchant(int n, int[] ar) {
        int[] soc =  new  int[100];

        for (int i = 0; i < ar.length; i++) {
            soc[ar[i]-1]++;
        }
        int c = 0;
        for (int i = 0; i < soc.length; i++) {
            if(soc[i]!=0 &&soc[i]%2==0){
                c+=soc[i]/2;
            }
            int v = soc[i] - 1;
            if(v!=0 && v%2==0){
                c+=v/2;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
