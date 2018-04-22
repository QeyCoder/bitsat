package day69;

import java.util.TreeSet;

/**
 * Created by Gaurav on 22/04/18.
 */


public class ClosestDistanceToChar {

    public static void main(String[] args) {
        ClosestDistanceToChar closestDistanceToChar = new ClosestDistanceToChar();
        System.out.println(closestDistanceToChar.shortestToChar("loveleetcode", 'e'));
    }

    static int MAX = Integer.MAX_VALUE;

    public int[] shortestToChar(String S, char C) {


        int[] op = new int[S.length()];
        TreeSet<Integer> integerTreeSet = new TreeSet<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                integerTreeSet.add(i);
            }
        }

        for (int i = 0; i < S.length(); i++) {

            int left = MAX;
            if (integerTreeSet.floor(i) != null) {
                left = Math.abs(integerTreeSet.floor(i) - i);
            }
            int right = MAX;
            if (integerTreeSet.ceiling(i) != null) {
                right = Math.abs(integerTreeSet.ceiling(i) - i);
            }
            op[i] = Math.min(left, right);

        }
        return op;

    }


}
