package seagmentTree;

import template.InputReader;

/**
 * Created by Gaurav on 31/01/18.
 */
public class RotateArray {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);

        int size = inputReader.readInt();
        int rotation = inputReader.readInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = inputReader.readInt();
        }
        for (int i = 0; i < rotation; i++) {

            int temp = array[0];

            for (int j = 1; j < array.length; j++) {
                array[j - 1] = array[j];
            }
            array[array.length - 1] = temp;

        }
    }
}
