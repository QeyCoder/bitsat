package day63;

import template.FastInputReader;

/**
 * Created by Gaurav on 02/04/18.
 */


public class BossImpression {


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

    private static String solution(int[] ip) {

        int count = 0;
        int prev = ip[0];
        for (int i = 1; i < ip.length; i++) {

            if (ip[i] < prev) {
                count++;

                if(i+1<ip.length){
                    prev = (ip[i]+ip[i+1])/2;
                }


            }    else{
                prev = ip[i];
            }



        }
        if (count > 1) {
            return "NO";
        }
        return "YES";
    }


}
