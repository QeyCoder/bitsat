package projectEuler;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 04/02/18.
 */

//https://www.hackerrank.com/contests/projecteuler/challenges/euler007


public class Problem7 {

    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader(System.in);
        int cases = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < cases; i++) {


            stringBuilder.append(solution(fastInputReader.readInt())).append("\n");
        }
    }


    static long solution(long number) {

        if(number==1){
            return 2;
        }else {
            int i = 0;
            int start = 3;
            while (i!=number){




            }
        }


return 0;
    }
}
