package codecheffeb2018;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 02/02/18.
 */
public class ChefAndCharacter {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader(System.in);

        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String data = fastInputReader.readString();
            stringBuilder = stringBuilder.append(solution(data));
        }
        System.out.println(stringBuilder.toString());
    }

    private static int solution(String data) {
        boolean c = false;
        boolean h = false;
        boolean e = false;
        boolean f = false;
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if (find('c')) {
                c = true;
                if (find('h') || find('e') || find('f')) {

                }
            }
            if (find('h')) {
                h = true;
                if (find('c') || find('e') || find('f')) {

                }
            }
            if (find('e')) {
                e = true;
                if (find('h') || find('c') || find('f')) {

                }
            }
            if (find('f')) {
                f = true;
                if (find('h') || find('e') || find('c')) {

                }
            }
            if (c && h && e && f) {
                count++;
            }

            c = false;
            h = false;
            e = false;
            f = false;
        }
        return count;
    }

    private static boolean find(char f) {
        return false;
    }
}
