package weekOfCode37;

import template.FastInputReader;

/**
 * Created by Gaurav on 16/04/18.
 */


public class AverageRating {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        int[] rating = fastInputReader.readIntArray(T);
        System.out.println(solution(rating));
    }

    private static String solution(int[] rating) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            if (rating[i] >= 90) {
                count++;
                sum += rating[i];
            }
        }
        double avg = sum / count;
        return String.format("%.2f", avg);
    }


}
