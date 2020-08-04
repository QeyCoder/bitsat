package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution342 {
    public boolean isPowerOfFour(int num) {
        if(num==1){
            return true;
        }



        int x = num & (num-1);
        int count=0;
        if(num>1 && x==0){

            while(num>1){
                num>>=1;
                count++;
            }
            if(count%2==0){
                return true;
            }
        }
        return false;
    }
}



