package roundzero.day48;

import roundzero.template.FastInputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gaurav on 12/02/18.
 */
public class LuckBalance {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int K = fastInputReader.readInt();

        long totalLuck = 0;
        List<Integer> integers
                = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            int luck = fastInputReader.readInt();
            int importance = fastInputReader.readInt();

            totalLuck += luck;

            if (importance == 1) {
                integers.add(luck);
            }
        }
        Collections.sort(integers);

        //As we have to loose maximum of K(so calculate the maximum one) competition so better to be loose with mininmum luck one . so sot
        //the minimum luck and win them. and we can lose the less important competition without taking care of luck

        int size = integers.size() - K;
        int luck = 0;
        for (int i = 0; i < size; i++) {
            luck += integers.get(i);
        }
            //multiplying with 2 as we have already calculated the luck in total luck
            // so if we are losing the competition the instead of gaining X point we are losing the X point so total - 2 * X
        System.out.println(totalLuck - 2 * luck);



    }

}
