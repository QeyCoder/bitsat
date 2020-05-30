package roundone;

import roundone.helper.DisJointSet;

public class Solution684 {

    static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            DisJointSet<Integer> integerDisJointSet =  new DisJointSet<>();
            for(int i=0; i< edges.length; i++){

                int src =  edges[i][0];
                int dest =  edges[i][1];
                integerDisJointSet.make(src);
                integerDisJointSet.make(dest);
                if(!integerDisJointSet.union(src,dest)){
                    return new int[]{src,dest};
                }
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        int[] ans = new Solution().findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
