package roundone;

import java.util.*;

public class Solution406 {

    static class Solution {


        public int[][] reconstructQueue(int[][] people) {
            List<int[]> list = new ArrayList<>();
            Arrays.sort(people, (a, b) -> {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                }
                return a[1] - b[1];
            });
            for (int[] a : people)
                list.add(a[1], a);
            return  list.toArray(new int[][]{});
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[][] t = solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        System.out.println();
    }
}
