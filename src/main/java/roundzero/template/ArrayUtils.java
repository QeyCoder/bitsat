package roundzero.template;

import java.util.Arrays;

class ArrayUtils {

    public static void fill(int[][] array, int value) {
        for (int[] row : array)
            Arrays.fill(row, value);
    }

}