package day46;

import template.FastInputReader;

/**
 * Created by Gaurav on 08/02/18.
 */
public class RichieRich {


    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();
        int k = fastInputReader.readInt();

        String data = fastInputReader.readString();

        System.out.println(solution(data, k));
    }

    private static String solution(String data, int k) {
        char[] splittedData = data.toCharArray();
        int index = 0;
        for (int i = 0; i < splittedData.length / 2; i++) {
            if (splittedData[i] != splittedData[splittedData.length - i - 1]) {
                index++;
            }
        }
        if (index > k) {
            return "-1";
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < splittedData.length; i++) {
            output.append(splittedData[i]);

        }
        return output.toString();
    }
}
