package roundzero.day16;

/**
 * Created by Gaurav on 21/11/17.
 */
public class DecimalToBinary {

    public static void main(String[] args) {


        int N = 8;
        //toBinary(N);
        fromBinary("1100");
        fromBinary("1110");
        fromBinary("1111");

    }

    private static void toBinary(int n) {

        StringBuilder op = new StringBuilder();
        while (n != 0) {
            op.append(n % 2);
            n = n / 2;
        }
        System.out.println(op.reverse());
    }


    private static void fromBinary(String n) {
        int val = 1;
        int sum = 0;
        for (int i = n.length()-1; i >=0; i--){
            if(n.charAt(i) == '1'){
                sum += val;
            }
            val*=2;
        }
        System.out.println(sum);
    }



}
