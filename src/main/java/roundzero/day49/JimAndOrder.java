package roundzero.day49;

import roundzero.template.FastInputReader;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Gaurav on 14/02/18.
 */
public class JimAndOrder {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        Pair[] t1 = new Pair[n];

        for (int i = 0; i < n; i++) {
            int t = fastInputReader.readInt();
            int val = t + fastInputReader.readInt();

            Pair pair = new Pair(i + 1, val);
            t1[i] = pair;
        }

        solution(t1);
    }

    private static void solution(Pair[] t1) {

        Arrays.sort(t1, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.val - o2.val;
            }
        });


        for (int i = 0; i < t1.length; i++) {
            System.out.print(t1[i].index + " ");
        }
    }

    static class Pair {
        int val;
        int index;

        public Pair(int i, int val) {
            this.index = i;
            this.val = val;
        }
    }
    private static void solution(int[] t, int[] d) {

    }
}
