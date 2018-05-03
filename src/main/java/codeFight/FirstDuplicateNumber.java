package codeFight;

/**
 * Created by Gaurav on 03/05/18.
 */

//https://codefights.com/interview-practice/task/pMvymcahZ8dY4g75q/description
public class FirstDuplicateNumber {


    public static void main(String[] args) {
        firstDuplicate(new int[]{2, 3, 3, 1, 5, 2});
    }

    static int firstDuplicate(int[] a) {


        for (int i = 0; i < a.length; i++) {

            int x = a[Math.abs(a[i] - 1)];
            if (x < 0) {
                return Math.abs(a[i]);
            } else {
                a[Math.abs(a[i] - 1)] = -a[Math.abs(a[i] - 1)];
            }


        }
        return -1;
    }


}
