package roundzero.serionLab;

import java.util.Random;

/**
 * Created by Gaurav on 20/04/18.
 */


public class RandomNumber {


    public static void main(String[] args) {

        System.out.println(randomString(-229985452) + " " + randomString(-147909649));
    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }

        return sb.toString();
    }

}
