package roundzero.day33;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class BuildingSpeed {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        int[] arr = new int[data.length];


        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(arr);
        int work = 0;

        for (int i = 0; i < arr.length - n; i = i + n) {
            work += Math.min(arr[i], arr[i + 1]);
        }

        System.out.println(work);


    }
}
