package roundzero.hourrank26;

import java.util.Scanner;

public class CloudDay {

    static long maximumPeople(long[] population, long[] location, long[] cloud, long[] cloudRange) {
        int m = cloud.length;

        Pair max = new Pair();
        max.data = -1;

        for (int i = 0; i < m; i++) {

            Pair op = peopleCovered(cloud[i], cloudRange[i], location, population);
            if (op.data > max.data) {
                max = op;
                max.index = i;
            }
        }

        //cloud[max.index] = 0;
        cloudRange[max.index] = 0;
        long pop = 0;
        for (int i = 0; i < m; i++) {


            long start = cloud[i] - cloudRange[i];
            long end = cloud[i] + cloudRange[i];

                for (int j = 0; j < location.length; j++) {
                    if (location[j] >= start && location[j] <= end) {

                    } else {
                        pop += population[j];
                    }


            }
        }

        return pop;


    }

    static class Pair {
        long data;
        int index;
    }

    private static Pair peopleCovered(long cLocation, long cRange, long[] location, long[] population) {


        long start = cLocation - cRange;
        long end = cLocation + cRange;

        long pplCovered = 0;
        for (int i = 0; i < location.length; i++) {
            if (location[i] >= start && location[i] <= end) {
                pplCovered += population[i];
            }
            if (location[i] > end) {
                break;
            }
        }
        Pair pair = new Pair();
        pair.data = pplCovered;
        return pair;


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] p = new long[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextLong();
        }
        long[] x = new long[n];
        for (int x_i = 0; x_i < n; x_i++) {
            x[x_i] = in.nextLong();
        }
        int m = in.nextInt();
        long[] y = new long[m];
        for (int y_i = 0; y_i < m; y_i++) {
            y[y_i] = in.nextLong();
        }
        long[] r = new long[m];
        for (int r_i = 0; r_i < m; r_i++) {
            r[r_i] = in.nextLong();
        }
        long result = maximumPeople(p, x, y, r);
        System.out.println(result);
        in.close();
    }
}
