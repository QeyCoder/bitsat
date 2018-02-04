package hourrank26;

import template.FastInputReader;

/**
 * Created by Gaurav on 02/02/18.
 */
public class ComboMeal {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader(System.in);
        int t = fastInputReader.readInt();
        StringBuilder stringBuilder
                = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int b = fastInputReader.readInt();
            int s = fastInputReader.readInt();
            int c = fastInputReader.readInt();

            stringBuilder.append(solution(b, s, c)).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static int solution(int b, int s, int c) {
        return b+s-c;

    }
}
