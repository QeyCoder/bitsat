package hackerearth;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;
public class MinMax {
    public static void main(String args[] ) throws Exception {
      Scanner Scanner = new Scanner(System.in);

      String x = Scanner.next();
      String y= Scanner.next();
       String xD =x.replaceAll("6", "5");
       String yD =y.replaceAll("6", "5");
        System.out.print(Integer.parseInt(xD)+Integer.parseInt(yD));
        
        xD =x.replaceAll("5", "6");
        yD =y.replaceAll("5", "6");
        System.out.print(" "+Integer.parseInt(xD)+Integer.parseInt(yD));


    }
}
