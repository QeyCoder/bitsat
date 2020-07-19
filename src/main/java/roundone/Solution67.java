package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution67 {


    public static void main(String[] args) {
        new Solution().addBinary("1","111");
    }

    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder st = new StringBuilder();

            if(a.length()>b.length()){
                String tmp = a;
                a=b;
                b=tmp;
            }
            int i =a.length()-1;
            int j=b.length()-1;
            int carry = 0;
            while(i>=0 && j>=0){
                char ac = a.charAt(i);
                char bc =b.charAt(j);


                if(ac=='1' && bc=='1'){
                    if(carry==0){
                        st.append(0);

                    }else{
                        st.append(1);
                    }
                    carry=1;

                }else if(ac=='0' && bc=='0'){
                    st.append(carry);
                    carry=0;
                }else{
                    if(carry==0){
                        st.append(1);
                        carry=0;
                    }else{
                        st.append(0);
                        carry=1;
                    }

                }

                i--;
                j--;

            }

            while (j>=0){
                char bc =b.charAt(j);
                if(carry ==1){
                    if(bc=='1'){
                        st.append(0);
                        carry=1;
                    }else{
                        st.append(1);
                        carry=0;
                    }
                }else{
                    st.append(bc);
                    carry=0;
                }

            }
            if(carry==1){
                st.append(carry);
            }

            return st.reverse().toString();





        }
    }
}



