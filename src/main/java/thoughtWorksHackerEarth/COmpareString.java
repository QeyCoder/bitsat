package thoughtWorksHackerEarth;

import template.FastInputReader;

/**
 * Created by Gaurav on 05/05/18.
 */


public class COmpareString {


    public static void main(String[] args) {

     /*COmpareString ref =  new COmpareString();
        ref.solution();
        */
        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int Q = fastInputReader.readInt();
        String A = fastInputReader.readString();
        String B = fastInputReader.readString();
        int[] Aarr = new int[A.length()];
        int[] Barr = new int[B.length()];
        for (int i = 0; i < A.length(); i++) {
            Aarr[i] = A.charAt(i) - '0';
        }

        for (int i = 0; i < B.length(); i++) {
            Barr[i] = B.charAt(i) - '0';
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (Q-- > 0) {

            int i = fastInputReader.readInt();
            Barr[i - 1] = 1;
            stringBuilder.append(solution(Aarr, Barr)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] aarr, int[] barr) {
        return 0;
    }


}
