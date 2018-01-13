package day38;

/**
 * Created by Gaurav on 07/01/18.
 */
public class HeapSort {


    enum HeapType {
        MIN, MAX
    }

    private HeapType heapType;

    public HeapSort(HeapType heapType) {
        this.heapType = heapType;
    }

    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            addToHeap(data[i]);
        }
        if (heapType == HeapType.MIN) {
            minHeap(data);
        } else {
            maxHeap(data);
        }

    }

    private void swap(int data[], int x, int y) {


        int temp = data[x];
        data[x] =  data[y];
        data[y]  = temp;
    }

    private void maxHeap(int[] data) {

    }

    private void addToHeap(int i) {

    }

    private void minHeap(int[] data) {

    }
}
