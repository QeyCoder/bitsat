package flipkart;

import template.FastInputReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 20/03/18.
 */


public class StockBuySell {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int N = fastInputReader.readInt();
            int[] ip = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(ip)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] ip) {

        List<Integer> locaMaxima   =  new ArrayList<>();
        List<Integer> locaMinima   =  new ArrayList<>();

        for (int i = 0; i < ip.length; i++) {

        }
        return 0;
    }


}
