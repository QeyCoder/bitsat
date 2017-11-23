package day123;

import java.util.Arrays;
import java.util.Comparator;

public class WeightSort {

    //Here we are going to use modify quick sort instead of sorting data based on values we are sorting based on weight
    private static final String SPACE = " ";

    public static String orderWeight(String strng) {
        String[] noList = strng.split(SPACE);

        Arrays.sort(noList, new Comparator<String>() {
            public int compare(String first, String second) {
                int res = Integer.compare(getWeight(first), getWeight(second));
                return res != 0 ? res : first.compareTo(second);
            }

        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < noList.length ;i++) {
            stringBuilder.append(noList[i]).append(SPACE);
        }
        return stringBuilder.toString().trim();

    }
  /*
    public static String orderWeight(String strng) {
        String[] noList = strng.split(SPACE);
        quickSortArray(noList, 0, noList.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < noList.length; i++) {
            stringBuilder.append(noList[i]).append(SPACE);
        }

        return stringBuilder.toString().trim();
    }*/


    private static void quickSortArray(String[] a, int start, int end) {
        if (start >= end) return;
        int pivot = partition(a, start, end);
        quickSortArray(a, start, pivot - 1);
        quickSortArray(a, pivot + 1, end);

    }

    private static int getWeight(String no) {
        int weight = 0;
        for (int i = 0; i < no.length(); i++) {
            weight += Character.getNumericValue(no.charAt(i));
        }
        return weight;
    }

    public static int partition(String[] data, int start, int end) {
        //picking any pivot element
        String[] pivotData = new String[end - start + 1];
        int pivotWeight = getWeight(data[start]);
        int i = 0, j = end - start, k;

        for (k = start + 1; k <= end; k++) {
            if (getWeight(data[k]) <= pivotWeight) {
                pivotData[i++] = data[k];
            } else if (getWeight(data[k]) > pivotWeight) {
                pivotData[j--] = data[k];
            }
        }
        pivotData[i] = data[start];

        for (k = start; k <= end; k++) {
            data[k] = pivotData[k - start];
        }
        return start + i;
    }


}
