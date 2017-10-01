/*
This Java code is given for your convenience. Feel free to modify as required.
*/

import java.util.ArrayList;
import java.util.List;

public class FibonacciSum {
    private List<Integer> fib;


    private int finFibo(int input) {
        fib = new ArrayList<>();
        if (input < 2) {
            return input;
        }
        int j = 0;
        while (genearateFibonnaci(j) <= input) {
            j++;
            //do nothing here
        }
        int count = 0;
        for (int i = fib.size() - 1; i > 0; i--) {

            Integer no = fib.get(i);
            if (no <= input) {
                input -= no;
                count++;
            }


        }
        return count;
    }


    int genearateFibonnaci(int input) {
        if (input == 0 || input == 1) {
            fib.add(input, 1);
        } else {
            fib.add(input, fib.get(input - 1) + fib.get(input - 2));
        }
        return fib.get(input);
    }


    public static void main(String[] args) {
        FibonacciSum cutShort1 = new FibonacciSum();
        System.out.println(cutShort1.finFibo(7));
    }
}