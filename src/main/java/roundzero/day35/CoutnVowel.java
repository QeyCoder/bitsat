package day35;/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//https://www.hackerearth.com/challenge/hiring/ubona-developer-hiring-challenge/problems/8d9a2cc891f241e68a7ee87a4138c83c/
class CoutnVowel {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());                // Reading input from STDIN

        for (int i = 0; i < size; i++) {


            String data = br.readLine();
            System.out.println(solution(data));

        }


    }

    /*private static int solution(String data) {
        List<Integer> integers = new ArrayList<>();
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        boolean a_f = false, e_f = false, i_f = false, o_f = false, u_f = false;
        for (int x = 0; x < data.length(); x++) {
            char chars = data.charAt(x);
            if (chars == 'a') {
                if (!a_f) {
                    a = a + 1;
                    a_f = true;
                }

            } else if (chars == 'e') {
                if (!e_f) {
                    e = e + 1;
                    e_f = true;
                }
            } else if (chars == 'i') {
                if (!i_f) {
                    i = i + 1;
                    i_f = true;
                }
            } else if (chars == 'o') {
                if (!o_f) {
                    o = o + 1;
                    o_f = true;
                }
            } else if (chars == 'u') {
                if (!u_f) {
                    u = u + 1;
                    u_f = true;
                }
            } else if (chars == '_') {
                integers.add(max(max(max(max(a == 0 ? 1 : a, e == 0 ? 1 : e), i == 0 ? 1 : i), o == 0 ? 1 : o), u == 0 ? 1 : u));
                a_f = false;
                e_f = false;
                i_f = false;
                o_f = false;
                u_f = false;
            }
        }
        int mul = 1;
        for (Integer integer : integers) {
            mul *= integer;
        }
        return mul;
        //return (a == 0 ? 1 : a) * (e == 0 ? 1 : e) * (i == 0 ? 1 : i) * (o == 0 ? 1 : o) * (u == 0 ? 1 : u);
    }*/

    private static String solution(String data) {
        List<BigInteger> integers = new ArrayList<>();
        BigInteger a = BigInteger.ZERO;
        BigInteger e = BigInteger.ZERO;
        BigInteger i = BigInteger.ZERO;
        BigInteger o = BigInteger.ZERO;
        BigInteger u = BigInteger.ZERO;
        for (int x = 0; x < data.length(); x++) {
            char chars = data.charAt(x);
            if (chars == 'a') {
                a = BigInteger.ONE;
            }
            if (chars == 'e') {
                e = BigInteger.ONE;
            }
            if (chars == 'i') {
                i = BigInteger.ONE;
            }
            if (chars == 'o') {
                o = BigInteger.ONE;
            }
            if (chars == 'u') {
                u = BigInteger.ONE;
            }
            if (chars == '_') {
                BigInteger sum = a.add(e).add(i).add(o).add(u);
                if (!sum.equals(BigInteger.ZERO)) {
                    integers.add(sum);
                }

                //a = e = i = o = u = 0;
            }
        }
        BigInteger mul = BigInteger.ONE;
        for (BigInteger integer : integers) {
            mul = mul.multiply(integer);
        }
        return mul.toString();
        //return (a == 0 ? 1 : a) * (e == 0 ? 1 : e) * (i == 0 ? 1 : i) * (o == 0 ? 1 : o) * (u == 0 ? 1 : u);
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
