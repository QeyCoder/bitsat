package roundzero.day123;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/fizzbuzz/
 * Created by Gaurav on 29/09/17.
 */
public class FizzBuzz {

    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                list.add("roundzero.day123.FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }

        }
        return list;
    }

    public static void main(String[] args) {

    }
    //Given a positive integer N,
    // print all the integers from 1 to N.
    // But for multiples of 3 print “Fizz”
    // instead of the number and for the multiples of 5 print “Buzz”.
    // Also for number which are multiple of 3 and 5, prints “roundzero.day123.FizzBuzz”.


}
