package roundzero.day56;

import roundzero.template.FastInputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gaurav on 24/02/18.
 */


public class UniqueArt {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();

        int N = fastInputReader.readInt();
        int[] arr = fastInputReader.readIntArray(N);
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder
                = new StringBuilder();
        Map<Integer, List<Integer>> integerIntegerMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int ip = arr[i];
            List<Integer> op = integerIntegerMap.get(ip);
            if (op == null) {
                op = new ArrayList<>();
            }
            op.add(i );
            integerIntegerMap.put(ip, op);
        }
        while (T-- > 0) {
            int S = fastInputReader.readInt();
            int E = fastInputReader.readInt();
            int count = 0;

            for (int i = S; i <= E; i++) {
                int ip = arr[i-1];
                List<Integer> op = integerIntegerMap.get(ip);
                if (op.size() == 1) {
                    count++;
                }
            }


            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder);
    }


}
