package day68;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Gaurav on 15/04/18.
 */


public class NumberPair {


    public static void main(String[] args) {

        numberOfPairs(new int[]{6,
                6,
                3,
                9,
                3,
                5,
                1
                }, 12);
    }

    static int numberOfPairs(int[] a, long k) {

        Set<Integer> integers = new TreeSet<>();

        for (int i = 0; i < a.length; i++) {
            integers.add(a[i]);
        }
        int count = 0;


        List<Integer> list = new ArrayList<>(integers);
        int s = 0;
        int e = list.size() - 1;
        while (s < e) {


            int result = list.get(s) + list.get(e);

            if (result > k) {
                e--;
            } else if (result < k) {
                s++;
            } else {
                count++;
                e--;
                s++;
            }


        }


        return count;
    }


}
