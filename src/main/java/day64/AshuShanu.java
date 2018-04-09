package day64;

import template.FastInputReader;

/**
 * Created by Gaurav on 07/04/18.
 */


public class AshuShanu {

//PEnign with seagment tree

    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        int[] data = fastInputReader.readIntArray(T);
        int Q = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (Q-- > 0) {
            int TYPE = fastInputReader.readInt();
            int x = fastInputReader.readInt() - 1;
            int y = fastInputReader.readInt();

            if (TYPE == 0) {
                data[x] = y;
            }
            if (TYPE == 1) {
                int count = 0;
                for (int i = x; i <y; i++) {

                    if (data[i] % 2 == 0) {
                        count++;
                    }

                }
                stringBuilder.append(count).append("\n");
            }
            if (TYPE == 2) {
                int count = 0;
                for (int i = x; i < y; i++) {

                    if (data[i] % 2 != 0) {
                        count++;
                    }

                }
                stringBuilder.append(count).append("\n");
            }

        }
        System.out.println(stringBuilder);
    }



}
