package roundzero.day45;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 06/02/18.
 */
public class WeightedUniformString {

    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        String data = fastInputReader.readString();
        int n = fastInputReader.readInt();
        boolean[] hash = new boolean[(int) 1e7];
        char lastChar = 0;
        int mult = 1;
        for (int i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            if (lastChar != 0) {
                if (currentChar == lastChar) {
                    mult++;
                    hash[mult * ((currentChar - 'a')+1)] = true;
                } else {
                    hash[(currentChar - 'a')+1] = true;
                    mult = 1;
                }
                lastChar = currentChar;
            } else {
                hash[(currentChar - 'a')+1] = true;
                lastChar = currentChar;
            }

        }
        StringBuilder stringBuilder
                = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int q = fastInputReader.readInt();

            stringBuilder = stringBuilder.append(solution(hash, q ) ? "YES" : "NO").append("\n");

        }
        System.out.println(stringBuilder.toString());
    }

    private static boolean solution(boolean[] hash, int q) {

        return hash[q];
    }
}
