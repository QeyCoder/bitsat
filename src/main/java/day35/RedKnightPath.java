package day35;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/contests/world-codesprint-12/challenges/red-knights-shortest-path
public class RedKnightPath {

    static class Pair {
        int x;
        int y;

    }
    //UL, UR, R, LR, LL, L


    static Pair UL(Pair pair) {

        pair.x = pair.x - 1;
        pair.y = pair.y - 2;
        return pair;
    }

    static Pair UR(Pair pair) {

        pair.x = pair.x - 1;
        pair.y = pair.y - 2;
        return pair;
    }

    static Pair R(Pair pair) {

        pair.y = pair.y + 2;
        return pair;

    }

    static Pair LR(Pair pair) {
        pair.x = pair.x + 1;
        pair.y = pair.y + 2;
        return pair;

    }

    static Pair L(Pair pair) {
        pair.x = pair.x - 2;
        return pair;

    }

    static Pair LL(Pair pair) {
        pair.x = pair.x - 1;
        pair.y = pair.y + 2;
        return pair;
    }

    private static void printShortestPath(int n, int i_s, int j_s, int i_e, int j_e) {
        int[][] matrix = new int[n][n];
        matrix[i_s][j_s] = 1;
    }



    static Stack<Pair> pairs  =  new Stack<>();


    static{

        //pairs.add();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}
