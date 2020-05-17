package roundzero.flipkart;

import java.util.Arrays;

/**
 * Created by Gaurav on 27/03/18.
 */


public class BoxStacking {


    public static void main(String[] args) {

        Dimension[] dimensions = {new Dimension(4, 6, 7), new Dimension(1, 2, 3), new Dimension(4, 5, 6), new Dimension(0, 12, 32)};


        solution(dimensions);

    }

    private static int solution(Dimension[] dimensions) {
        int permutLength = dimensions.length * 3;
        Dimension[] rotated = new Dimension[permutLength];
        int count = 0;
        for (int i = 2; i < permutLength; i += 3) {
            Dimension[] rotation = getRotation(dimensions[count++]);
            rotated[i - 2] = rotation[0];
            rotated[i - 1] = rotation[1];
            rotated[i] = rotation[2];
        }

        Arrays.sort(rotated);
        return finalSolution(rotated);
    }

    private static int finalSolution(Dimension[] rotated) {

        int[] orignal = new int[rotated.length];
        int[] result = new int[rotated.length];


        for (int i = 0; i < orignal.length; i++) {
            orignal[i] = rotated[i].h;
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        int i = 0;
        int j = 1;

        while (i < j) {
            while (j < rotated.length) {
                if (canPut(rotated, i, j)) {
                    if (orignal[j] + rotated[i].h > orignal[i]) {
                        orignal[i] = orignal[j] + rotated[i].h;
                        result[j] = i;
                        i++;
                    }
                    j++;
                }
            }
            i = 0;
        }
        int max = -1;
        for (int k = 0; k < orignal.length; k++) {
            if (result[i] > max) {
                max = orignal[i];
            }
        }
        return max;
    }

    private static boolean canPut(Dimension[] rotated, int i, int j) {

        return (rotated[i].b > rotated[j].b && rotated[i].l > rotated[j].l);
    }

    private static Dimension[] getRotation(Dimension dimension) {
        Dimension[] rotation = new Dimension[3];

        rotation[0] = Dimension.createDimension(dimension.h, dimension.l, dimension.b);
        rotation[1] = Dimension.createDimension(dimension.l, dimension.h, dimension.b);
        rotation[2] = Dimension.createDimension(dimension.b, dimension.h, dimension.l);

        return rotation;
    }


    static class Dimension implements Comparable<Dimension> {

        private int l;
        private int b;
        private int h;

        public Dimension(int h, int l, int b) {
            this.l = l;
            this.b = b;
            this.h = h;
        }

        Dimension() {

        }


        public static Dimension createDimension(int h, int l, int b) {
            Dimension dimension = new Dimension();
            dimension.h = h;

            if (l > b) {
                dimension.l = l;
                dimension.b = b;
            } else {
                dimension.l = b;
                dimension.b = l;
            }
            return dimension;
        }


        @Override
        public int compareTo(Dimension o) {
            if (this.b * this.l > o.b * o.l) {
                return -11;
            }
            return 1;
        }
    }

}
