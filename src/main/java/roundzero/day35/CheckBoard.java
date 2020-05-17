package day35;/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
//https://www.hackerearth.com/codearena/ring/2ca4ce1/
class CheckBoard {
    public static void main(String args[] ) throws Exception {
      int hash = 512;
        int score = 512;

        BufferedReader bufferedReader
                 =  new BufferedReader(new InputStreamReader(System.in));

        String[] dataa  = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(dataa[0]);
        int m = Integer.parseInt(dataa[1]);
        int a = 0;
        int b =0;
        for (int i = 0; i < n; i++) {
            String data = bufferedReader.readLine();
            for (int j = 0; j < data.length(); j++) {
                if(data.charAt(j) =='#'){
                    b++;
                }if(data.charAt(j) =='_'){
                    a++;
                }

            }

        }

        int min = Math.min(a, b);
        System.out.println(Math.min(score/min, hash/min));


    }
}
