package roundzero.tataHealth;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 22/04/18.
 */


public class BinarySwap {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();

        String A = fastInputReader.readString();
        String B = fastInputReader.readString();
        System.out.println(solution(A, B));
    }

    private static int solution(String a, String b) {
        int a1 = 0, a0 = 0, b1 = 0, b0 = 0;
        if (a.length() != b.length()) return -1;
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] - '0' == 0) {
                a0++;
            } else {
                a1++;
            }

        }

        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] - '0' == 0) {
                b0++;
            } else {
                b1++;
            }
        }
        if (a0 != b0 || a1 != b1) {
            return -1;
        }


        int start = 0;
        int end = aArr.length - 1;
        int count = 0;
        while (start < end) {

            if (aArr[start] == bArr[start]) {
                start++;
            } else {
                while (start < end && bArr[end] != aArr[start]) {
                    end--;
                }
                if (start > end) {
                    return -1;
                }
                swap(aArr, start, end);
                end = aArr.length - 1;
                start++;
                count++;
            }
        }


        return count;
    }

    private static void swap(char[] aArr, int start, int end) {
        char temp = aArr[start];
        aArr[start] = aArr[end];
        aArr[end] = temp;
    }


}
