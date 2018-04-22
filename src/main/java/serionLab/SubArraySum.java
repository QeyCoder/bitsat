package serionLab;

import template.FastInputReader;

/**
 * Created by Gaurav on 19/04/18.
 */


public class SubArraySum {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int K = fastInputReader.readInt();


            int[] ip = fastInputReader.readIntArray(N);
            stringBuilder.append(solution(ip, K)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(int[] ip, int k) {
        int len = 0;
        int currentLength = 0;
        boolean kFaced = false;
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] == k) {
                kFaced = true;
                currentLength++;
            } else if (ip[i] > k) {
                if (kFaced) {
                    len += currentLength;
                }
                kFaced = false;
                currentLength = 0;
                //stop here;
            } else {
                currentLength++;
            }

        }
        if (kFaced) {
            len += currentLength;
        }
        return len;
    }


}
