package leetCode;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _670 {


    static class Solution {
        public int maximumSwap(int num) {
            char[] digits = Integer.toString(num).toCharArray();

            int[] buckets = new int[10];
            for (int i = 0; i < digits.length; i++) {
                buckets[digits[i] - '0'] = i;
            }


            for (int i = 0; i < digits.length; i++) {
                for (int j = 9; j > digits[i] - '0'; j--) {
                    if (buckets[j] > i) {
                        swap(digits, i, buckets[j]);
                        return Integer.valueOf(new String(digits));
                    }


                }
            }
            return num;

        }

        void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution re = new Solution();
        re.maximumSwap(92998);
    }

}
