package day71;

/**
 * Created by Gaurav on 27/04/18.
 */


public class ComplexNumber {


    public static void main(String[] args) {
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.complexNumberMultiply("-1+-1i"
                , "1+-1i");

    }

    public String complexNumberMultiply(String a, String b) {
        //(a1+b1)*(a2+b2) =  a1a2 + a1b2+ b1a2+ b1b2;
        String[] asplt = a.split("\\+");
        String[] bsplt = b.split("\\+");


        int a1 = Integer.parseInt(asplt[0]);
        int b1 = Integer.parseInt(asplt[1].replace("i", ""));

        int a2 = Integer.parseInt(bsplt[0]);
        int b2 = Integer.parseInt(bsplt[1].replace("i", ""));


        int a1a2 = a1 * a2;
        int b1b2 = -1* b1 * b2;

        int a1b2i = (a1 * b2 + b1 * a2);


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a1a2 + b1b2).append("+").append(a1b2i).append("i");
        return stringBuilder.toString();

    }
}
