package day42;

import java.util.Scanner;

/**
 * Created by Gaurav on 29/01/18.
 */
public class HourGlass {

    public static void main(String[] args) {
        Scanner scanner
                = new Scanner(System.in);

        int[][] matrix = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] splitted = scanner.nextLine().split(" ");
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = Integer.parseInt(splitted[j]);
            }
        }
        System.out.println(solution(matrix));
    }

    private static int solution(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = matrix[i][j] +
                        matrix[i][j + 1] +
                        matrix[i][j + 2] +
                        matrix[i + 1][j + 1] +
                        matrix[i + 2][j] +
                        matrix[i + 2][j + 1] +
                        matrix[i + 2][j + 2];
                if (temp > max) {
                    max = temp;
                }
            }

        }
        return max;
    }
}
