package roundzero.day52;

import roundzero.template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 17/02/18.
 */
public class ExamRush {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int T = fastInputReader.readInt();

        int[] time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = fastInputReader.readInt();
        }
        Arrays.sort(time);
        long index = 0;
        long sum = 0;
        for (int i = 0; i < time.length; i++) {
            long temp = sum + time[i];
            if (temp < T) {
                //continue;
                sum = temp;
            } else {
                index = i;
                break;
            }
        }
        System.out.println(index);


    }
}
