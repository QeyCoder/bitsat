package day16;

import java.util.Scanner;

public class Cipher {

    static int los = 97;
    static int loe = 122;
    static int uos = 65;
    static int uoe = 90;

    //https://www.hackerrank.com/challenges/caesar-cipher-1/problem
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named CloudDay. */
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String data = in.nextLine();
        int K = Integer.parseInt(in.nextLine());
        solution(N, data, K);
    }

    private static void solution(int n, String data, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        k = k % 26;
        for (int i = 0; i < data.length(); i++) {
            char d = data.charAt(i);
            if (d >= los && d <= loe) {
                if (loe - d < k) {
                    d = (char) (los + (d - los + k) % 26);
                } else {
                    d += k;
                }
                stringBuilder.append(d);
            } else if (d >= uos && d <= uoe) {
                if (uoe - d < k) {
                    d = (char) (uos + (d - uos + k) % 26);
                } else {
                    d += k;
                }
                stringBuilder.append(d);
            } else {
                stringBuilder.append(d);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}