package roundzero.day56;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 24/02/18.
 */


public class SummerLesson {


    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        int m = fastInputReader.readInt();
        int[] arry = fastInputReader.readIntArray(n);
        StringBuilder stringBuilder
                = new StringBuilder();
        int[] op = solution(arry, m);
        for (int i = 0; i < op.length; i++) {
            stringBuilder.append(op[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static int[] solution(int[] arry, int m) {
        int[] ints = new int[m];
        for (int i = 0; i < arry.length; i++) {
            ints[arry[i]]++;
        }
        return ints;
    }


}
