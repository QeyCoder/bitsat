package day48;

import template.FastInputReader;

/**
 * Created by Gaurav on 12/02/18.
 */
public class GridChallenge {
    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = fastInputReader.readInt();
            char[] data = new char[N];
            for (int j = 0; j < N; j++) {
                data[j] = fastInputReader.readString().charAt(0);
            }
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static char[] solution(char[] data) {
        return new char[0];
    }
}
