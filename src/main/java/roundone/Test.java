package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int no = Integer.parseInt(line);
        System.out.println(no % 2 == 0 ? no == 2 ? "NO" : "YES" : "NO");


    }
}
