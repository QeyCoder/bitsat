package weekOfCode37;

import template.FastInputReader;

/**
 * Created by Gaurav on 17/04/18.
 */


public class SimpleLanguage {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        int x = 0;
        while (T-- > 0) {
            String ip = fastInputReader.readString();
            int N = fastInputReader.readInt();

            if (ip.equals("set")) {
                if (N > x) {
                    x = N;
                }
            } else if (ip.equals("add")) {
                if (N + x > x) {
                    x = N + x;
                }
            }

        }

        System.out.println(x);
    }



}
