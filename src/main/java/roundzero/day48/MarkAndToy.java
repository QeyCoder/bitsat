package roundzero.day48;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToy {

    static long maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        long sum = 0;
        int index = 0;
        for (int i = 0; i < prices.length; i++) {
            long temp = sum + k;

            if (temp > k) {
                break;
            }
            sum = temp;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] prices = new int[n];
        for (int prices_i = 0; prices_i < n; prices_i++) {
            prices[prices_i] = in.nextInt();
        }
        long result = maximumToys(prices, k);
        System.out.println(result);
        in.close();
    }
}
