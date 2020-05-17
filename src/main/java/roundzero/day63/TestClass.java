package day63;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.util.Scanner;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class TestClass {
    public static void main(String args[]) throws Exception {


        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());

        for (int i = 0; i < size; i++) {
            String name = s.nextLine();                 // Reading input from STDIN
            String[] split = name.split(" ");
            StringBuilder st = new StringBuilder();
            for (int j = split.length - 1; j >= 0; j--) {

                st.append(split[j]).append(" ");

            }
            System.out.println(st.toString());

        }


        // Write your roundzero.code here

    }
}
