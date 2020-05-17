package day63;

/**
 * Created by Gaurav on 03/04/18.
 */


public class Arbitrage {


    static int[] arbitrage(String[] quotes) {
        int[] op = new int[quotes.length];
        for (int i = 0; i < quotes.length; i++) {
            String[] quote = quotes[i].split(" ");

            double usdEur = Double.parseDouble(quote[0]);
            double eurGmp = Double.parseDouble(quote[1]);
            double gmpUsd = Double.parseDouble(quote[2]);
            double total = 100000;
            double result = total / usdEur / eurGmp / gmpUsd;
            op[i] = result > total ? (int) (result - total) : 0;
        }

        return op;

    }

    public static void main(String[] args) {
        System.out.println(arbitrage(new String[]{"1.1837", " 1.3829 ", "0.6102"})[0]);
    }


}
