package day35;/* IMPORTANT: Multiple classes and nested static classes are supported */


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.io.BufferedReader;
import java.io.InputStreamReader;
//https://www.hackerearth.com/codearena/ring/224be70/
class SqareNumber {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long no = Long.parseLong(br.readLine());                // Reading input from STDIN


        double d = Math.sqrt(no);
        if((long)d ==  d){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }
}
