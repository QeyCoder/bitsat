import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Gaurav on 30/09/17.
 */
public class DigitFormation {
    public int solve(ArrayList<Integer> A, int length, int maxValue) {
        if (A != null && A.size() == 0) {
            return 0;
        }


        for (Integer integer : A) {
            for (Integer integer1 : A) {
                
            }
        }
        BigInteger max = BigInteger.valueOf(maxValue);
        System.out.println(max.getLowestSetBit());

        return 0;
    }

    public static void main(String[] args) {
        DigitFormation digitFormation = new DigitFormation();
        digitFormation.solve(null,2,45 );
    }
}
