package roundzero.day68;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 14/04/18.
 */


public class GameStrategy {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int[] data = fastInputReader.readIntArray(N);
            stringBuilder.append(dpSolution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int dpSolution(int[] data) {
        Node[][] dp = new Node[data.length + 1][data.length + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = new Node();
            }
        }


        for (int i = 0; i < data.length; i++) {
            dp[i][i].first = data[i];
            dp[i][i].pick = i;
        }


        for(int l = 2; l <= data.length; l++){
            for(int i=0; i <= data.length - l; i++){
                int j = i + l -1;
                if (data[i] + dp[i + 1][j].second > data[j] + dp[i][j - 1].second) {
                    dp[i][j].first = data[i] + dp[i + 1][j].second;
                    dp[i][j].pick = i;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = data[j] + dp[i][j - 1].second;
                    dp[i][j].pick = j;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        return dp[0][data.length-1].first;
    }


    static class Node {
        int first;
        int second;
        int pick = 0;

    }


    static int getOptimal(int[] data, int l, int r) {
        if (data[l] + data[r - 1] >= data[r] + data[l + 1]) {
            return l;
        } else {
            return r;
        }


    }

    private static int solution(int[] data) {

        int i = 0;
        int j = data.length - 1;
        boolean isMyTurn = true;
        int p1 = 0;
        int p2 = 0;


        while (i <= j) {

            int x = getOptimal(data, i, j);
            if (x == i) {
                p1 += data[i++];
            } else {
                p1 += data[j--];

            }

            int y = getOptimal(data, i, j);
            if (y == i) {
                p2 += data[i++];
            } else {
                p2 += data[j--];

            }
        }


        return p1;
    }


}
