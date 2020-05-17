package roundzero.day51;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 17/02/18.
 */
public class ServerRoomSafety {

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int n = fastInputReader.readInt();

        int[] pos = fastInputReader.readIntArray(n);
        int[] height = fastInputReader.readIntArray(n);


        //System.out.println(solution(pos, height, n));
        System.out.println(bruteForceSolution(pos, height, n));


    }

    private static String bruteForceSolution(int[] pos, int[] height, int n) {
        boolean left = false;
        boolean right = false;
        int x = 0;


        for (int i = 0; i < n - 1; i++) {

            while (x < n - 1 && pos[i] + height[i] >= pos[x + 1]) {
                left = true;
                x++;
            }
            if (i == x) {
                left = false;
                break;
            }

        }
        x = n - 1;
        for (int i = n - 1; i > 0; i--) {

            while (x > 0 && pos[i] - height[i] <= pos[x - 1]) {
                right = true;
                x--;
            }
            if (i == x) {
                right = false;
                break;
            }

        }


        if (left && right) {
            return "BOTH";
        } else if (!left && !right) {
            return "NONE";
        } else if (left && !right) {
            return "LEFT";
        }
        return "RIGHT";
    }

    //with o(n)

    private static String solution(int[] pos, int[] height, int n) {


        boolean left = false;
        boolean right = false;

        for (int i = 0; i < n - 1; i++) {

            if (pos[i] + height[i] >= pos[i + 1]) {
                left = true;
            } else {

                left = false;
                if (i >= 0)
                    break;
            }

        }
        for (int i = n - 1; i > 0; i--) {

            if (pos[i] - height[i] <= pos[i - 1]) {
                right = true;
            } else {
                right = false;
                if (i <= n - 1)
                    break;
            }

        }

        if (left && right) {
            return "BOTH";
        } else if (!left && !right) {
            return "NONE";
        } else if (left && !right) {
            return "LEFT";
        }
        return "RIGHT";
    }
}
