package roundzero.day50;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 15/02/18.
 */
public class ClosingTheTweet {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader();
        int N = fastInputReader.readInt();
        int k = fastInputReader.readInt();
        int[] tweets = new int[N];

        int openTweet = 0;
        for (int i = 0; i < k; i++) {
            String input = fastInputReader.readString();
            if (input.equals("CLICK")) {
                int index = fastInputReader.readInt() - 1;
                if (tweets[index] == 0) {
                    tweets[index] = 1;
                    openTweet++;
                } else {
                    tweets[index] = 0;
                    openTweet--;
                }

            } else {
                for (int j = 0; j < N; j++) {
                    tweets[j] = 0;
                    openTweet = 0;
                }
            }

            System.out.println(openTweet);


        }
    }
}
