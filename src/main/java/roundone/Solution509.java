package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution509 {

    class Solution {
        public int fib(int N) {


            int first = 0;
            int second =1;
            if(N==0){
                return 0;
            }
            for(int i = 2; i<= N;i++){

                int tmp= second+first;
                first =second;
                second =tmp;

            }
            return second;

        }
    }
}



