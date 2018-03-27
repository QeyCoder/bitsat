package flipkart;

import template.FastInputReader;

/**
 * Created by Gaurav on 14/03/18.
 */


public class KeyPad {

    static String[] hashTable = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        String T = fastInputReader.readString();
        String res = new String();
        solution(T, T.length() - 1, res);
    }

    private static void solution(String ip, int index, String res) {


        if (index == -1) {
            System.out.println(res);
            return;
        }
        int digit = ip.charAt(index) - '0';
        String key = hashTable[digit];
        int len = key.length();
        for (int i = 0; i < len; i++) {
            solution(ip, index - 1, key.charAt(i) + res);
        }


    }


}
