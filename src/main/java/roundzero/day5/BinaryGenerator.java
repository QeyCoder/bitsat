package day5;

/**
 * Created by Gaurav on 02/10/17.
 */
public class BinaryGenerator {

    public String findDigitsInBinary(int a) {
        if(a==0){
            return String.valueOf(a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0) {
            stringBuilder.append(a % 2);
            a = a / 2;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        BinaryGenerator binaryGenerator  =  new BinaryGenerator();
        System.out.println(binaryGenerator.findDigitsInBinary(6));
    }
}
