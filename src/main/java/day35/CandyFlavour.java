package day35;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//https://www.hackerearth.com/codearena/ring/8e611ca/
class CandyFlavour {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());                // Reading input from STDIN
        long ans = 0;
        for (int i = 3; i < cases; i++) {

            ans += (i - 1) * 1 * (i - 2);

        }
        System.out.println(ans);


        // Write your code here

    }
}
