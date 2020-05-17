package day5;

/**
 * Created by Gaurav on 02/10/17.
 */
public class ReverseInteger {

    public int reverse(int a) {
        boolean negetiveNo = false;
        if (a < 0) {
            negetiveNo = true;
            a = -a;
        }


        int no = reverseNumber(a);
        return negetiveNo ? -no : no;


    }

    private int reverseNumber(int a) {
        long no = 0;
        int temp = a;

        int noOfDigit = 0;
        while (temp != 0) {
            temp = temp / 10;
            noOfDigit++;

        }
        noOfDigit--;
        while (a > 0) {
            int reminder = a % 10;
            no += reminder *  Math.pow(10, noOfDigit--);
            a = a / 10;
        }
        if (no > Integer.MAX_VALUE || no < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) no;
        }
    }


    public static void main(String[] args) {
        ReverseInteger
                reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(254));
        System.out.println(reverseInteger.reverse(-1146467285));
    }
}
