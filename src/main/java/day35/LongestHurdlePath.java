package day35;

import java.util.Scanner;

/**
 * Created by Gaurav on 19/12/17.
 */
public class LongestHurdlePath {
    static int R = 3;
    static int C = 10;
    static int INT_MIN = Integer.MIN_VALUE;
    static int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner
                = new Scanner(System.in);
        System.out.println("Enter size of hurdle space seperated M N");

        String[] data = scanner.nextLine().split(" ");
        int row = Integer.parseInt(data[0]);
        int col = Integer.parseInt(data[1]);
        int[][] hurdle = new int[row][col];
        System.out.println("Enter " + row + " space seprated times");
        for (int i = 0; i < row; i++) {
            String[] spltdArray = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                hurdle[i][j] = Integer.parseInt(spltdArray[j]);
            }
        }

        System.out.println("Enter source comma(,) seperated");
        String[] src = scanner.nextLine().split(",");
        int srcR = Integer.parseInt(src[0]);
        int srcC = Integer.parseInt(src[1]);
        System.out.println("Enter destination comma(,) seperated");
        String[] dest = scanner.nextLine().split(",");
        int desR = Integer.parseInt(dest[0]);
        int desC = Integer.parseInt(dest[1]);
        solution(row, col, hurdle, srcR, srcC, desR, desC);
    }

    private static void solution(int row, int col, int[][] hurdle, int srcR, int srcC, int desR, int desC) {

        boolean[][] visitedArray = new boolean[row][col];

        Pair sol = findRecursiveSolution(visitedArray, hurdle, srcR, srcC, desR, desC);

        if (sol.found) {
            System.out.println(sol.sol);
        } else {
            System.out.println("no sol");
        }

    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static class Pair {
        int sol;
        boolean found;

        public Pair(int len, boolean found) {
            this.sol = len;
            this.found = found;
        }
    }

    private static Pair findRecursiveSolution(boolean[][] visitedArray, int[][] hurdle, int srcR, int srcC, int desR, int desC) {
        if (srcR == desR && srcC == desC) {
            return new Pair(0, true);
        }

        if (srcR < 0 || srcR >= visitedArray.length || srcC < 0 || srcC >= visitedArray[0].length || hurdle[srcR][srcC] == 0 || visitedArray[srcR][srcC] == true) {
            // invalid entry
            return new Pair(Integer.MAX_VALUE, false);

        }
        //update the path
        visitedArray[srcR][srcC] = true;

        int res = Integer.MIN_VALUE;
        Pair sol;
        sol = findRecursiveSolution(visitedArray, hurdle, srcR + 1, srcC, desR, desC);
        if (sol.found) {
            res = max(res, sol.sol);
        }
        sol = findRecursiveSolution(visitedArray, hurdle, srcR, srcC + 1, desR, desC);
        if (sol.found) {
            res = max(res, sol.sol);
        }
        sol = findRecursiveSolution(visitedArray, hurdle, srcR - 1, srcC, desR, desC);
        if (sol.found) {
            res = max(res, sol.sol);
        }
        sol = findRecursiveSolution(visitedArray, hurdle, srcR, srcC - 1, desR, desC);
        if (sol.found) {
            res = max(res, sol.sol);
        }

        //back track
        visitedArray[srcR][srcC] = false;
        if (res != Integer.MIN_VALUE) {
            return new Pair(res + 1, true);
        }

        return new Pair(Integer.MAX_VALUE, false);
    }
//////////////////////////////////////////////////////////////////////////////////////

}
