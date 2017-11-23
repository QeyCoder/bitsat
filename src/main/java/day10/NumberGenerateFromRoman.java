package day10;

/**
 * Created by Gaurav on 08/10/17.
 */
public class NumberGenerateFromRoman {


    private int getChar(String no) {


        switch (no) {

            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
        }

        return 0;
    }

    //XIX
    int getNumber(String romanNumber) {

        String[] splittedArray = romanNumber.split("");
        int[] numArray = new int[splittedArray.length];
        for (int i = 0; i <= splittedArray.length - 1; i++) {
            numArray[i] = getChar(splittedArray[i]);
        }
        int sum = numArray[numArray.length - 1];
        int last = numArray[numArray.length - 1];
        for (int i = numArray.length - 2; i>= 0; i--) {


            if (numArray[i] >= last) {
                sum += numArray[i];
            } else if (numArray[i] < last) {
                sum -= numArray[i];
            }

            last = numArray[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberGenerateFromRoman numberGenerateFromRoman
                = new
                NumberGenerateFromRoman();
        System.out.println(numberGenerateFromRoman.getNumber("MDCCCIV"));
        System.out.println(numberGenerateFromRoman.getNumber("XX"));
    }
}
