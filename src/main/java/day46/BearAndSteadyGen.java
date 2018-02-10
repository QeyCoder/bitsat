package day46;

import template.FastInputReader;

/**
 * Created by Gaurav on 08/02/18.
 */
public class BearAndSteadyGen {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        String data = fastInputReader.readString();
        System.out.println(solution(data, n / 4));
    }

    private static int solution(String data, int n) {


        String GENE = "ACGT";
        int[] arr = new int[4];


        for (int i = 0; i < data.length(); i++) {
            arr[GENE.indexOf(data.charAt(i))]++;
        }

        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        while (i < data.length() && j < data.length()) {


            if (!balanced(arr, n)) {
                arr[GENE.indexOf(data.charAt(j++))]--;
            } else {
                min = minimum(min, j - i);
                arr[GENE.indexOf(data.charAt(i++))]++;
            }


        }
        return min;
    }

    private static int minimum(int i, int j) {
        return i < j ? i : j;
    }

    private static boolean balanced(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) {
                return false;
            }
        }
        return true;
    }

}
