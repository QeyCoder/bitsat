package roundzero.day48;

import roundzero.template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 14/02/18.
 */
public class PriyankaAndToy {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        int[] toys = new int[T];
        for (int i = 0; i < T; i++) {
            toys[i] = fastInputReader.readInt();
        }

        System.out.println(solution(toys));
    }

    private static int solution(int[] toys) {


        Arrays.sort(toys);
        int start = toys[0];
        int total = 1;
        for (int i = 1; i < toys.length; i++) {

            if (toys[i] <= start + 4) {
                //do nothing
            } else {
                start = toys[i];
                total++;
            }

        }
        return total;

    }
}
