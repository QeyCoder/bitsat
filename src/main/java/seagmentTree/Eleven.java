package seagmentTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Gaurav on 29/01/18.
 */
public class Eleven {
    public static void main(String[] args) {


        Scanner scanner
                = new Scanner(System.in);
        int ip = Integer.parseInt(scanner.nextLine());

        System.out.println(function(ip));

    }

    static long[] fibonacci;


    /**
     * @param i
     * @return
     */
    private static String function(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        fibonacci = new long[i + 1];

        fibonacci[0] = 1;

        fibonacci[1] = 1;

        Set<Long> bigIntegerSet = new LinkedHashSet<>();
        bigIntegerSet.add(1l);
        for (int j = 2; j <= i; j++) {
            fibonacci[j] = fibonacci[j - 1] + fibonacci[j - 2];
            bigIntegerSet.add(fibonacci[j]);
        }
        for (int j = 1; j <= i; j++) {
            if (bigIntegerSet.contains((long)j)) {
                stringBuilder = stringBuilder.append('O');
            } else {
                stringBuilder = stringBuilder.append('o');
            }

        }

        return stringBuilder.toString();
    }

}
