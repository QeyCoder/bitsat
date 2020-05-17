package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/codearena/ring/932765a/
class BalanceString {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());                // Reading input from STDIN
        for (int i = 0; i < cases; i++) {

            String data = br.readLine();

            int x = 0;
            for (int j = 0; j < data.length(); j++) {
                x ^= data.charAt(j) - '0';
            }

            // System.out.println(count);
            if (x == 0) {
                System.out.println("1");
            } else {
                System.out.println("-1");
            }

        }


    }

}
