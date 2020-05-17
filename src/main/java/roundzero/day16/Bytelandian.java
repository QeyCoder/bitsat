package roundzero.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Gaurav on 02/11/17.
 */
public class Bytelandian {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {


            int inputC = Integer.parseInt(bufferedReader.readLine());
            System.out.println(excahngeCoin(inputC, integerIntegerHashMap));
        }

    }

    private static int excahngeCoin(Integer inputC, HashMap<Integer, Integer> integerIntegerHashMap) {
        if (inputC <12)
            return inputC;

        int coinA = inputC / 2;
        int coinB = inputC / 3;
        int coinC = inputC / 4;

        if (integerIntegerHashMap.get(coinA) == null) {
            integerIntegerHashMap.put(coinA, excahngeCoin(coinA, integerIntegerHashMap));
        }
        if (integerIntegerHashMap.get(coinB) == null) {
            integerIntegerHashMap.put(coinB, excahngeCoin(coinB, integerIntegerHashMap));
        }
        if (integerIntegerHashMap.get(coinC) == null) {
            integerIntegerHashMap.put(coinC, excahngeCoin(coinC, integerIntegerHashMap));
        }


        int sum = integerIntegerHashMap.get(coinA) + integerIntegerHashMap.get(coinB) + integerIntegerHashMap.get(coinC);


        if (sum > inputC) {
            integerIntegerHashMap.put(inputC, sum);
        } else {
            integerIntegerHashMap.put(inputC, inputC);
        }
        return integerIntegerHashMap.get(inputC);


    }
}
