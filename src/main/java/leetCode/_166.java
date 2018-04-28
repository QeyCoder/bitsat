package leetCode;

/**
 * Created by Gaurav on 27/04/18.
 */


public class _166 {


    public static String fractionToDecimal(int numerator, int denominator) {


        double a = numerator;
        double b = denominator;

        double doubleDevision = a / b;
        int intDevision = numerator / denominator;


        String ans1 = String.valueOf(doubleDevision);
        if (doubleDevision == intDevision) {
            return String.valueOf(intDevision);
        } else if (ans1.length() == 3) {
            return String.format("%.1f", doubleDevision);
        } else {
            StringBuilder stringBuilder = new
                    StringBuilder();
            boolean pointfaced = false;
            //stringBuilder.append(ans1.charAt(0));
            for (int i = 0; i < ans1.length()-1; i++) {
                if (!pointfaced) {
                    stringBuilder.append(ans1.charAt(i));
                    if (ans1.charAt(i) == '.') {
                        pointfaced = true;
                    }
                }
                else  if (pointfaced) {
                    if (ans1.charAt(i) == ans1.charAt(i + 1)) {
                        stringBuilder.append("(").append(ans1.charAt(i)).append(")");
                        break;
                    } else {
                        stringBuilder.append(ans1.charAt(i));
                    }
                }

            }
            return stringBuilder.toString();
        }


    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(1, 7));

        System.out.println(fractionToDecimal(4, 2));
        System.out.println(fractionToDecimal(1, 2));

    }
}