package day46;

import template.FastInputReader;

/**
 * Created by Gaurav on 08/02/18.
 */
public class SherlockAndANagram {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        StringBuilder stringBuilder
                = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String data = fastInputReader.readString();
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(String data) {




        return 0;
    }
}
