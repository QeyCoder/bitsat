package day16;

/**
 * Created by Gaurav on 13/11/17.
 */
public class MinDiffArray {


    int abs(int x) {
        return ((x < 0) ? (-1 * x) : x);
    }

    int min(int x, int y) {
        return (x < y) ? x : y;
    }

    int divide(int[] a, int i, int X, int Y) {
        if (i >= a.length) {
            return abs(X - Y);
        } else {
            int x1 = divide(a, i + 1, X + a[i], Y);
            int x2 = divide(a, i + 1, X, Y + a[i]);
            return min(x1, x2);
        }
    }

    public static void main(String[] args) {
        MinDiffArray minDiffArray
                = new MinDiffArray();
        int[] arr = {4, 5, 9, 11, 17, 3};
        System.out.println(minDiffArray.divide(arr, 0, 0, 0));
    }
}
