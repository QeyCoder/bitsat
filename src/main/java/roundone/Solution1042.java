package roundone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1042 {

    public static void main(String[] args) {
        int[] ANS = new Solution().gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}});
        System.out.println(ANS);
    }

    //1042. Flower Planting With No Adjacent
    static class Solution {
        public int[] gardenNoAdj(int N, int[][] paths) {

            int[] ans = new int[N];
            Map<Integer, Set<Integer>> storage = new HashMap<>();
            for (int i = 0; i < N; i++) {
                storage.put(i, new HashSet<>());
            }
            for (int i = 0; i < paths.length; i++) {
                int src = paths[i][0] - 1;
                int dest = paths[i][1] - 1;
                storage.get(src).add(dest);
                storage.get(dest).add(src);
            }

            for (int i = 0; i < N; i++) {
                int[] color = new int[5];
                for (int k : storage.get(i)) {
                    color[ans[k]] = 1;
                }

                for (int j = 4; j > 0; j--) {
                    if (color[j] != 1) {
                        ans[i] = j;
                    }
                }
            }
            return ans;


        }

//        public int[] gardenNoAdj(int N, int[][] path) {
//
//            Map<Integer, Set<Integer>> storage= new HashMap<>();
//            for(int i = 0; i< N; i++){
//                storage.put(i, new HashSet<>());
//            }
//            for(int i=0; i<path.length;i++){
//                int src = path[i][0]-1;
//                int dest =path[i][1]-1;
//                storage.get(src).add(dest);
//                storage.get(dest).add(src);
//            }
//
//
//
//            int ans[] =  new int[N];
//            for(int i=0; i<N;i++){
//                int[] color  = new int[5];
//                for(int ip: storage.get(i)){
//                    color[ans[ip]]=1;
//                }
//
//
//                for(int j=4; j>=1; j--){
//                    if(color[j]!=1){
//                        ans[i] =j;
//                    }
//                }
//
//            }
//
//            return ans;
//
//
//
//        }


    }
}
