package day4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Gaurav on 01/10/17.
 */
public class FactorNumber {

    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> integerList = new ArrayList<>();
        if(A == 1){
            integerList.add(1);
            return integerList;
        }
        //int[] result = new int[A / 2+1];


        for (int i = 1; i <= Math.sqrt(A) ; i++) {
            if (A % i == 0) {
                if (A / i == i) {
                    integerList.add(i);
                } else {
                    int no = A / i;
                    integerList.add(i);
                    integerList.add(no);
                }
            }
        }
        Collections.sort(integerList);
        return integerList;
    }

    public static void main(String[] args) {
        FactorNumber factorNumber
                = new FactorNumber();
        System.out.println(factorNumber.allFactors(1));
    }
}
