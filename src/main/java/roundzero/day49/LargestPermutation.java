package roundzero.day49;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 14/02/18.
 */
public class LargestPermutation {

    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int K = fastInputReader.readInt();

        int[] permut = new int[N];
        int index[] = new int[N + 1];
        for (int i = 0; i < N; i++) {
            permut[i] = fastInputReader.readInt();
            index[permut[i]] = i;
        }
        System.out.println(solution(index, permut, K));
    }

    private static String solution(int[] index, int[] permut, int k) {

        int i = permut.length;
        while (k > 0 && i > 0) {

            int largest = permut[index[i]];
            int current = permut[permut.length - i];
            if (largest > current) {
                swap(permut, index[i], permut.length - i);
                swap(index, i, permut.length - 1);
                k--;
            }
            i--;

        }
        StringBuilder stringBuilder =  new StringBuilder();
        for (int j = 0; j < permut.length; j++) {
            stringBuilder.append(permut[i]);
        }
        return stringBuilder.toString();


    }

    private static void swap(int[] permut, int i, int j) {
        Integer temp = permut[i];
        permut[i] = permut[j];
        permut[j] = temp;
    }
}
