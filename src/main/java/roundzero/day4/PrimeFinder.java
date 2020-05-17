package roundzero.day4;

import java.util.ArrayList;

/**
 * Created by Gaurav on 01/10/17.
 */
public class PrimeFinder {
    public ArrayList<Integer> sieve(int a) {

        ArrayList<Integer> prime =  new ArrayList<>();
        int[] integers =  new int[a+1];
        int p = 2;

        for (int i = 0; i <= a; i++) {
            integers[i]=1;
        }
        for (int i = 2; i <= a; i++) {
            if (integers[i] == 1) {
                for (int j = 2; i * j <= a; j++) {
                    integers[i * j]= 0;
                }
            }
        }
        for (int i = 2; i < integers.length; i++) {
            if(integers[i] == 1){
                prime.add(i);
            }
        }
        return prime;


    }

    public static void main(String[] args) {
        PrimeFinder primeFinder = new PrimeFinder();
        System.out.println(primeFinder.sieve(7));
    }
}
