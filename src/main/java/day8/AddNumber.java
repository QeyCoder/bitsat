package day8;

/**
 * Created by Gaurav on 05/10/17.
 */
public class AddNumber {

    public int[] plusOne(int[] A) {
        boolean caryPending = false;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 9) {
                A[i] = 0;
                if (i == 0) {
                    caryPending = true;
                }
            } else {
                A[i] = A[i] + 1;
                break;
            }
        }

        int i = 0;


        int count = 0;
        int[] newArray;
        if (caryPending) {
            newArray = new int[A.length - i + 1];
            newArray[0] = 1;
            count++;
            for (int j = i +1; j < A.length; j++) {
                newArray[count++] = A[j];
            }
        } else {

            while (i < A.length && A[i] == 0) {
                i++;
            }
            newArray = new int[A.length - i];
            for (int j = i; j < A.length; j++) {
                newArray[count++] = A[j];
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        AddNumber addNumber = new AddNumber();
        addNumber.plusOne(new int[]{9, 9, 9, 9, 9});
    }


}
