package roundzero.day59;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 04/03/18.
 */


public class SamAndTheSubString {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        String T = fastInputReader.readString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(solution(T)).append("\n");
        System.out.println(stringBuilder);
    }

    private static long solution(String ip) {
        int mod = 1000000007;
        long jo = 1;
        long sum = 0;
        for (int i = ip.length() - 1; i >= 0; i--) {
            sum = (sum + ((ip.charAt(i) - '0') * (i + 1) * jo)) % mod;
            jo=  (jo*10l + 1)%mod;
        }
        return sum;

    }


}
