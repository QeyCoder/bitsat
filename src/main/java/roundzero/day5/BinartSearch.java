package day5;

/**
 * Created by Gaurav on 02/10/17.
 */
public class BinartSearch {

    int recursiveBinarySearch(int[] a, int start, int end, int no) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (a[mid] == no) {
                return mid;
            } else if (no < a[mid]) {
                return recursiveBinarySearch(a, start, mid - 1, no);
            } else {
                return recursiveBinarySearch(a, mid + 1, end, no);
            }
        }
        return -1;
    }


    int interativeBinarySearch(int[] a, int no) {

        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == no) {
                return mid;
            } else if (a[mid] > no) {

                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;


    }

    public static void main(String[] args) {
        BinartSearch binartSearch = new BinartSearch();

        int[] inputArray = {2, 5, 9, 11, 17, 29, 31};
        int numberToBeFind = 29;
        System.out.println(binartSearch.recursiveBinarySearch(inputArray, 0, inputArray.length - 1, numberToBeFind));
        System.out.println(binartSearch.interativeBinarySearch(inputArray, numberToBeFind));
    }
}
