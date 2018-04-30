package leetCode;

import template.FastInputReader;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _113 {


    public static void main(String[] args) {

     /*_113 ref =  new _113();
        ref.solution();
        */
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            stringBuilder.append(solution()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution() {
        return 0;
    }


}
