package day42;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Gaurav on 26/01/18.
 */
public class WinningLotery {

    public static void main(String[] args) throws FileNotFoundException {/*

        Scanner scanner
                = new Scanner(new FileInputStream(new File("/Users/Gaurav/Desktop/input16.txt")));*/
    Scanner scanner =  new Scanner(System.in);
        int totalTickets = Integer.parseInt(scanner.nextLine());
        int[] values = new int[1 << 10];
        for (int i = 0; i < totalTickets; i++) {
            String content = scanner.nextLine();
            int hash = 0;
            for (int j = 0; j < content.length(); j++) {
                int index = (int) content.charAt(j) - '0';
                hash |= 1 << index;
            }
            values[hash]++;
        }
        BigInteger count = BigInteger.ZERO;
        for (int i = 0; i < 1 << 10; i++) {
            for (int j = i; j < 1 << 10; j++) {
                int op = i | j;
                if (op == 1023) {
                    if (i == j) {
                        count = count.add(new BigInteger(String.valueOf(values[i] * (values[j] - 1) / 2)));
                    } else {
                        count = count.add(new BigInteger(String.valueOf(values[i] * values[j])));
                    }
                }
            }

        }
        //601837702
        System.out.println(count);
    }
}
