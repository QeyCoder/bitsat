package roundzero.day66;

import java.util.ArrayList;

/**
 * Created by Gaurav on 10/04/18.
 */


public class FindPermutation {


    public static void main(String[] args) {


        FindPermutation findPermutation
                = new FindPermutation();
        System.out.println(findPermutation.findPerm("ID", 3));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> integers = new ArrayList<>();
        int i = 1;
        int j = B;
        for (int k = 0; k < A.length(); k++) {
            if (A.charAt(k) == 'I') {
                integers.add(i++);
            } else {
                integers.add(B--);
            }
        }
        integers.add(i);
        return integers;
    }


}
