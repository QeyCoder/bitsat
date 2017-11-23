package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 02/11/17.
 */
public class Ciel {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = bufferedReader.readLine().split(" ");
        int A = Integer.parseInt(values[0]);
        int B = Integer.parseInt(values[1]);


        int C = A - B;

        if ((C + 1) % 10 == 0) {
            C = C - 1;
        } else {
            C = C + 1;
        }
        System.out.println(C);
        bufferedReader.close();
    }
}
