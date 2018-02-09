package day46;

import template.FastInputReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 08/02/18.
 */
public class SherlockAndANagram {


    public static void main(String[] args) {
        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        StringBuilder stringBuilder
                = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String data = fastInputReader.readString();
            stringBuilder.append(solution(data)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solution(String data) {

        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= data.length(); i++) {
            for (int j = i + 1; j <= data.length(); j++) {
                strings.add(data.substring(i, j));
            }
        }

/*
        Comparator<? super String> compartor = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        strings.sort(compartor);*/

        int count = 0;
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i+1; j < strings.size(); j++) {
                String A = strings.get(i);
                String B = strings.get(j);
                if (i != j && A.length() == B.length()) {
                    int[] aHash = getHash(A);
                    int[] bHash = getHash(B);
                    if (comapre(aHash, bHash)) {
                        count++;
                    }

                }

            }
        }
        return count;
    }

    private static boolean comapre(int[] aHash, int[] bHash) {
        for (int i = 0; i < aHash.length; i++) {
            if (aHash[i] != bHash[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getHash(String a) {

        int[] hash = new int[26];

        for (int i = 0; i < a.length(); i++) {
            hash[a.charAt(i) - 'a']++;
        }
        return hash;

    }
}
