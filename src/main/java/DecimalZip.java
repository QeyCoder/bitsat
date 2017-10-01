import java.math.BigInteger;

/**
 * Created by Gaurav on 30/09/17.
 */
public class DecimalZip {

    public int solution(int A, int B) {
        BigInteger max = new BigInteger(String.valueOf(100000000));

        String aStr = String.valueOf(A);
        String bStr = String.valueOf(B);

        int lengthA = aStr.length();
        int lengthB = bStr.length();
        String maxRefence;
        int min;
        if (lengthA > lengthB) {
            min = lengthB;
            maxRefence = aStr;
        } else if (lengthA < lengthB) {
            min = lengthA;
            maxRefence = bStr;
        } else {
            //equal here pick any one
            min = lengthA;
            maxRefence = null;
        }

        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < min; i++) {
            finalString.append(aStr.charAt(i));
            finalString.append(bStr.charAt(i));
        }
        if (maxRefence != null) {
            finalString.append(maxRefence.substring(min , maxRefence.length()));
        }
        BigInteger no = new BigInteger(finalString.toString());

        if (no.compareTo(max) > 0) {
            return -1;
        } else {
            return no.intValue();
        }
    }

    public static void main(String[] args) {
        DecimalZip decimalZip =  new DecimalZip();
        System.out.println(decimalZip.solution(12345, 67889898));
    }
}
