package day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 26/11/17.
 */
//https://practice.geeksforgeeks.org/problems/game-of-xor/0
public class XorofXorOfSubArray {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());


        for (int i = 0; i < cases; i++) {
            int size =Integer.parseInt(br.readLine());
            if (size % 2 == 0) {
                System.out.println(0);
            } else {
                String[] array =  br.readLine().split(" ");

                System.out.println(solution(array));
            }

        }
    }

    private static int solution(String[] array) {
        int xor = 0;
//use alternate elements as sub array will canceled 1 with n 2 with n-1 and so on only mid element is remainging and that is every alternate elements
        for (int i = 0; i < array.length ; i = i + 2) {
            xor ^= Integer.parseInt(array[i]);
        }
        return xor;
    }

}
