package day35;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//https://www.hackerearth.com/challenge/hiring/sapient-global-markets-java-hiring-challenge-1/problems/23926912b530454b8f00f99a75a034d6/
class GameOfNumber {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int a[] = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 0; i < a.length; i++) {

            int greater = nextGreater(a, i);

            if (greater == -1) {
                System.out.println("-1");
            } else {
                int smaller = nextSmaller(a, greater);
                if (smaller == -1) {
                    System.out.println("-1");
                } else {
                    System.out.println(a[smaller]);
                }
            }
        }


    }


    static int nextGreater(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                return i;
            }
        }
        return -1;

    }

    static int nextSmaller(int[] arr, int index) {

        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                return i;
            }
        }
        return -1;

    }
}
