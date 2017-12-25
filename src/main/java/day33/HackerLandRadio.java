package day33;

import java.util.Arrays;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
public class HackerLandRadio {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        System.out.println(solution(x, k));
    }

    static int solution(int[] array, int k) {
        int count = 0;
        int n =  array.length;
        Arrays.sort(array);
        int i = 0;
        while (i < n) {
            count++;
            int location = array[i] + k;


            while (i< n && array[i]<= location){
                i++;
            }
            i--;
            //put here
            location =  array[i]+k;

            while (i<n && array[i]<=location){
                i++;
            }

        }
        return  count;


    }
}
