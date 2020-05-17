package roundzero.cureskin;

import roundzero.template.FastInputReader;

import java.util.TreeMap;

/**
 * Created by Gaurav on 15/04/18.
 */


public class SpecialArray {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int N = fastInputReader.readInt();
        int Q = fastInputReader.readInt();

        int orignalSum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            int ip = fastInputReader.readInt();

            Integer op = map.get(ip);
            if (op == null) {
                op = 0;
            }
            map.put(ip, op+1);
            orignalSum += ip;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (Q-- > 0) {
            TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>(map);
            int sum = orignalSum;
            int K = fastInputReader.readInt();

            while (K-- > 0) {
                Integer min = integerIntegerTreeMap.firstKey();

                Integer max = integerIntegerTreeMap.lastKey();
                int dif = max - min;
                Integer result = integerIntegerTreeMap.get(dif);

                if (result == null) {
                    result = 0;
                }
                integerIntegerTreeMap.put(dif, result+1);


                Integer minVal = integerIntegerTreeMap.get(min);
                if (minVal == 1) {
                    integerIntegerTreeMap.remove(min);
                } else {
                    integerIntegerTreeMap.put(min, minVal - 1);
                }

                Integer maxVal = integerIntegerTreeMap.get(max);
                if (maxVal == 1) {
                    integerIntegerTreeMap.remove(max);
                } else {
                    integerIntegerTreeMap.put(max, maxVal - 1);
                }


                sum -= max;
                sum -= min;
                sum += dif;

            }
            stringBuilder.append(sum).append("\n");


        }
        System.out.println(stringBuilder);
    }


}
