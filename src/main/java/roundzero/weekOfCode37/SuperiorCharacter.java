package roundzero.weekOfCode37;

import roundzero.template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 18/04/18.
 */


public class SuperiorCharacter {


    public static void main(String[] args) {


        String b = "A";
        String a = new String("A");

        System.out.println(a == b);

        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            int[] frquency = new int[26];
            for (int i = 0; i < 26; i++) {
                frquency[i] = fastInputReader.readInt();
            }
            stringBuilder.append(solution(frquency)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static long solution(int[] freq) {
         int length = Arrays.stream(freq).sum();
         int optMaxSup = (length - 1) / 2;

        int chrUpToLmt = 0;
        int limitLevel = 0;
        for (; chrUpToLmt <= length - optMaxSup && limitLevel < freq.length; ++limitLevel) {
            chrUpToLmt += freq[limitLevel];
        }
         int supAtLimitLevel = optMaxSup + chrUpToLmt - length;
        chrUpToLmt -= freq[--limitLevel];

         int matchedSupCount = Math.min(supAtLimitLevel, Math.max(chrUpToLmt - 1, 0));
        return optMaxSup - (supAtLimitLevel - matchedSupCount);
    }


}
