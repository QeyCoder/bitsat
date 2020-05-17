package roundzero.day55;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 22/02/18.
 */


public class NumberDivisible {


    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder
                stringBuilder = new StringBuilder();
//        long dp[] = new long[(int) 1e18];
        while (T-- > 0) {
            long N = Long.parseLong(fastInputReader.readString());

            stringBuilder.append(solution(N)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static long solution(long n) {

        long ans = 0l;
        ans+= n/2;
        ans+= n/3;
        ans+= n/5;
        ans+= n/7;
        ans-=n/6;
        ans-=n/10;
        ans-=n/14;
        ans-=n/15;
        ans-=n/21;
        ans-=n/35;
        ans+=n/30;
        ans+=n/42;
        ans+=n/70;
        ans+=n/105;
        ans-=n/210;
        return n-ans;




    }


}
