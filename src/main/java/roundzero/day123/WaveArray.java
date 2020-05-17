package roundzero.day123;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/wave-array/
 * Created by Gaurav on 29/09/17.
 */
public class WaveArray {


    public static void main(String[] args) {
        WaveArray waveArray = new WaveArray();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        waveArray.wave(array);
        System.out.println(array);
    }

    public ArrayList<Integer> wave(ArrayList<Integer> a) {


        quickSortArray(a, 0, a.size()-1);
        for (int i = 0; i < a.size() - 1; i=i+2) {
            swap(a, i, i + 1);
        }
        return a;
    }

    private void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    private void quickSortArray(ArrayList<Integer> a, int start, int end) {

        if (start < end) {
            int pivot = partition(a, start, end);
            quickSortArray(a, start, pivot - 1);
            quickSortArray(a, pivot + 1, end);
        }

    }

    private int partition(ArrayList<Integer> a, int start, int end) {


        int pivot = a.get(end);


        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (a.get(j) < pivot) {
                i++;
                swap(a, i, j);
            }

        }
        swap(a, i + 1, end);
        return i + 1;
    }
}
