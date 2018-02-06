package day45;

import template.FastInputReader;

import java.util.Arrays;

/**
 * Created by Gaurav on 06/02/18.
 */
public class TwoCharacter {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader();
        int len = fastInputReader.readInt();
        String data = fastInputReader.readString();

        System.out.println(twoCharaters(data));


    }

    static int twoCharaters(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        Arrays.sort(hash);
        for (int i = hash.length-1; i > 0; i--) {
            if (hash[i] - hash[i - 1] == 1) {
                return hash[i] + hash[i - 1];
            }
        }
        return 0;
    }
}
