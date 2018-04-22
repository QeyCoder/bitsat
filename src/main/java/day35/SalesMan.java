package day35;

import java.util.Scanner;

/**
 * Created by Gaurav on 15/12/17.
 */

//https://www.hackerrank.com/contests/world-codesprint-12/challenges/the-salesman
public class SalesMan {

         public int minimumTime (int[] x) throws Exception{
            int max =  Integer.MIN_VALUE;
            int min =  Integer.MAX_VALUE;

            for(int i = 0; i< x.length; i++){


                if(x[i]> max){
                    max = x[i];
                }

                if(x[i]< min){
                    min = x[i];
                }
            }

            return max-min;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for(int a0 = 0; a0 < t; a0++){
                int n = in.nextInt();
                int[] x = new int[n];
                for(int x_i = 0; x_i < n; x_i++){
                    x[x_i] = in.nextInt();
                }
               // int result = minimumTime(x);
               // System.out.println(result);
            }
            in.close();
        }
    }

