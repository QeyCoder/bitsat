package roundone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1042 {


    //1042. Flower Planting With No Adjacent
    class Solution {

        public int[] gardenNoAdj(int N, int[][] path) {

            Map<Integer, Set<Integer>> storage= new HashMap<>();
            for(int i = 0; i< N; i++){
                storage.put(i, new HashSet<>());
            }
            for(int i=0; i<path.length;i++){
                int src = path[i][0]-1;
                int dest =path[i][1]-1;
                storage.get(src).add(dest);
                storage.get(dest).add(src);
            }



            int ans[] =  new int[N];
            for(int i=0; i<N;i++){
                int[] color  = new int[5];
                for(int ip: storage.get(i)){
                    color[ans[ip]]=1;
                }


                for(int j=4; j>=1; j--){
                    if(color[j]!=1){
                        ans[i] =j;
                    }
                }

            }

            return ans;



        }


    }
}
