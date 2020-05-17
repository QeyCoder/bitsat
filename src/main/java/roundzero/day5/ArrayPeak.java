package day5;

/**
 * Created by Gaurav on 02/10/17.
 */
public class ArrayPeak {


    public static void main(String[] args) {
        ArrayPeak arrayPeak = new ArrayPeak();

        int[] inputArray = {87, 63, 51, 25, 40, 24, 6, 1,9,10};
        arrayPeak.findPeakPoints(inputArray);
    }

    void findPeakPoints(int[] a) {


        int start = 0;
        int end = a.length - 1;
        int peak = 0;
        boolean findLow = true;
        while (end >= start && end - start >= 2) {
            int mid = (start + end) / 2;
            if (findLow) {
                if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                    System.out.println(a[mid]);
                    findLow = !findLow;
                }
            } else {
                if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                    System.out.println(a[mid]);
                    findLow = !findLow;
                }
            }
            start = mid - 1;

        }

        System.out.println(peak);

    }
}
