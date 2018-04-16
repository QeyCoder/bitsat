package day68;

import template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 15/04/18.
 */


public class StickCut {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();

        int[] re = cutSticks(new int[]{
                5,
                4,
                4,
                2,
                2,
                8});
        System.out.println(re);
    }

    static int[] cutSticks(int[] stick) {


        Arrays.sort(stick);

        StringBuilder stringBuilder = new StringBuilder();
        int left = stick.length;

        int curr = stick[0];
        int currentLengthStick = 0;
        stringBuilder.append(left).append(" ");

        for (int i = 0; i < stick.length; i++) {
            if (curr == stick[i]) {
                currentLengthStick++;
            } else {
                left -= currentLengthStick;
                currentLengthStick = 1;
                curr = stick[i];
                stringBuilder.append(left).append(" ");
            }
        }


        String[] op = stringBuilder.toString().split(" ");
        int[] result = new int[op.length];

        for (int i = 0; i < op.length; i++) {
            result[i] = Integer.parseInt(op[i]);
        }
        return result;
    }


}
