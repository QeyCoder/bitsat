package roundzero.day30;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/insertionsort1/problem
public class InsertionSort1 {
    
    

    public static void insertIntoSorted(int[] ar) {


        for (int i = 0; i <ar.length-1 ; i++) {

            int j = i+1;
            while (ar[i]<ar[j]){

            }

        }
    }
    
    
/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertIntoSorted(ar);
        printArray(ar);
    }
    
    
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
 
