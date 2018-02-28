package day51;

import template.FastInputReader;

/**
 * Created by Gaurav on 16/02/18.
 */
public class TeamFormation {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int t = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (t-- > 0) {
            int n = fastInputReader.readInt();
            long[] team = new long[n];
            for (int i = 0; i < n; i++) {
                team[i] = fastInputReader.readInt();
            }
            stringBuilder.append(solution(team)).append("\n");
        }
    }

    private static int solution(long[] team) {
        return 0;
    }
}
