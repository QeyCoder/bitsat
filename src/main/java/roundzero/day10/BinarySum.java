package day10;

/**
 * Created by Gaurav on 08/10/17.
 */
public class BinarySum {


    public static void main(String[] args) {
        BinarySum binarySum
                = new BinarySum();
        //System.out.println(binarySum.addBinary("1010110111001101101000",
          //      "1000011011000000111100110"));
        System.out.println(binarySum.addBinary("11",
                "1"));
    }

    public String addBinary(String A, String B) {

        int firstLen = A.length();
        int secondLen = B.length();
        String buffer;
        if (firstLen > secondLen) {
            buffer = A.substring(0, firstLen - secondLen);
            A = A.substring(firstLen - secondLen, A.length());
        } else if (firstLen < secondLen) {
            buffer = B.substring(0, secondLen - firstLen);
            B = B.substring(secondLen - firstLen, B.length());
        } else {
            buffer = null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int sum = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            int a = A.charAt(i) - '0';
            int b = B.charAt(i) - '0';
            if ((a == 1 && b == 1 && carry == 1)) {
                sum = 1;
                carry = 1;
            } else if (a == 1 && b == 1 && carry == 0) {
                sum = 0;
                carry = 1;

            } else if (((a == 0 && b == 1) && carry == 1) || ((a == 1 && b == 0) && carry == 1)) {
                sum = 0;
                carry = 1;
            } else if (((a == 0 && b == 1) && carry == 0) || ((a == 1 && b == 0) && carry == 0)) {
                sum = 1;
                carry = 0;
            } else if (a == 0 && b == 0 && carry == 0) {
                sum = 0;
                carry = 0;
            } else if (a == 0 && b == 0 && carry == 1) {
                sum = 1;
                carry = 0;
            }
            stringBuilder.append(sum);
        }
        if (buffer != null) {

            for (int i = buffer.length() - 1; i >= 0; i--) {

                int a = buffer.charAt(i) - '0';

                if (a == 0 && carry == 1 || a == 1 && carry == 0) {
                    stringBuilder.append(1);
                    carry = 0;
                } else if (a == 1 && carry == 1) {
                    stringBuilder.append(0);
                    carry = 1;
                } else if (a == 0 && carry == 0) {
                    {
                        stringBuilder.append(0);
                    }
                }
            }
        }

        if (carry == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().

                toString();
    }
}
