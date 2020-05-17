package roundzero.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 10/11/17.
 */
public class SortedArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine());


        System.out.println(solution(bufferedReader.readLine().split(" ")));

    }

    private static int solution(String[] split) {


        //int[] temp = new int[split.length - 2];
        //int count = 0;
        int stepRequired = 0;
        for (int i = 1; i < split.length; i++) {
            int prev = Integer.parseInt(split[i - 1]);
            int next = Integer.parseInt(split[i]);
            int diff = next - prev;
            if (diff <= 0) {
                split[i] = String.valueOf(next + (-diff + 1));
                stepRequired += -diff + 1;
            }
        }
        return stepRequired;
    }
}
