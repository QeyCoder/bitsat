package day36;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class StringMonster {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());                // Reading input from STDIN
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());                // Reading input from STDIN
            String[] strings = new String[N];
            for (int j = 0; j < N; j++) {
                strings[j] = br.readLine();
            }
            String op = br.readLine();
            int[] ints = new int[26];
            for (int j = 0; j < op.length(); j++) {
                int loc = op.charAt(j) - 'a';
                ints[loc]++;
            }



        }
    }
}
