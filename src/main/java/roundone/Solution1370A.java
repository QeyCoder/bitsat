package roundone;

import java.util.Scanner;

public class Solution1370A {
    public static int findMaxGCD(int input[], int size) {
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, input[i]);
        }
        int count[] = new int[max + 1];
        for (int i = 0; i < size; i++) {
            count[input[i]]++;
        }
        int counter = 0;

        for (int i = max; i >= 1; i--) {
            int j = i;
            while (j <= max) {
                if (count[j] > 0) {
                    counter += count[j];
                }
                j += i;
                if (counter == 2) {
                    return i;
                }
            }
            counter = 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            int no = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[no ];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
            System.out.println(findMaxGCD(arr, arr.length));

        }

    }
}
