package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerearth.com/codearena/ring/31f1437/
class ShiroSamosa {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");                // Reading input from STDIN
        int shop = Integer.parseInt(data[0]);
        int money = Integer.parseInt(data[1]);

        String[] somosaPrice = br.readLine().split(" ");
        int[] somos = new int[shop];


        for (int i = 0; i < shop; i++) {
            somos[i] = Integer.parseInt(somosaPrice[i]);
        }


        Arrays.sort(somos);
        for (int i = 0; i < somos.length; i++) {
            if (money == 0) {
                System.out.println(i);
                break;
            }
            if (money < 0) {
                System.out.println(i - 1);
            }

            money -= somos[i];

        }


    }
}
