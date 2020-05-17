package roundzero.day16;

import java.util.Scanner;

public class HurdleJump {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
        }
        System.out.println(jumpHurdle(height, k));
    }

    private static int jumpHurdle(int[] height, int k) {
        int count = 0;
        for (int i = 0; i < height.length; i++) {


            if (height[i] > k) {
                int dif = height[i] - k;
                k +=dif;
                count+=dif;
            }
        }
        return count;
    }
}
