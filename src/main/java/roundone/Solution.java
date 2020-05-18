package roundone;

import java.util.Arrays;

class Solution1394 {
    public int findLucky(int[] arr) {
        int tmp[] =new int[501];
        for(int i: arr){
            tmp[i]++;
        }

        for(int i=0;i< tmp.length;i++){
            if(tmp[i]!=i){
                tmp[i]=0;
            }
        }

        for(int i=tmp.length;i>=0;i--){
            if(tmp[i]!=0){
                return  i;
            }
        }

        return -1;

    }
}