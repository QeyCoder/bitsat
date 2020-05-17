package day62;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 08/03/18.
 */


public class MotherVertex {


    public static void main(String[] args) {


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
