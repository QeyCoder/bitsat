
import java.util.Arrays;
/**
 * Created by Gaurav on 01/09/17.
 */
public class Racko {
    void solution(int A[]) {


        Arrays.sort(A);
        calculateCost(A);

    }

    private int calculateCost(int[] integerList) {
        int maxCost = 0;
        int lastValue = 0;
        for (Integer integer : integerList) {

            int diff = Math.abs(integer - lastValue);
            lastValue = integer;
            if (diff > maxCost) {
                maxCost = diff;
            }
        }
        return maxCost / 2;
    }
}
