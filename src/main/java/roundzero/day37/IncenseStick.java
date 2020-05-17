package roundzero.day37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Gaurav on 06/01/18.
 */
public class IncenseStick {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] stickCord1 = br.readLine().split(" ");
        int x1 = Integer.parseInt(stickCord1[0]);
        int y1 = Integer.parseInt(stickCord1[1]);
        Pair stick1 = new Pair(x1, y1);

        String[] stickCord2 = br.readLine().split(" ");
        int x2 = Integer.parseInt(stickCord2[0]);
        int y2 = Integer.parseInt(stickCord2[1]);
        Pair stick2 = new Pair(x2, y2);

        int N = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[N];


        String[] X = br.readLine().split(" ");
        String[] Y = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            pairs[i] = new Pair(Integer.parseInt(X[i]), Integer.parseInt(Y[i]));
        }

        int Q = Integer.parseInt(br.readLine());


        String[] qI = br.readLine().split(" ");
        int[] numbers = new int[qI.length];


        for (int i = 0; i < Q; i++) {
            numbers[i] = Integer.parseInt(qI[i]);
        }
        Arrays.sort(numbers);
        System.out.println(solution(pairs, stick1, stick2, numbers));


    }

    private static String solution(Pair[] pairs, Pair stick1, Pair stick2, int[] T) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < T.length; i++) {


            int a1 = stick1.x + T[i];
            int b1 = stick1.y + T[i];
            double r1 = T[i];

            int a2 = stick2.x + T[i];
            int b2 = stick2.y + T[i];
            double r2 = T[i];
            if (intersect(a1, b1, a2, b2, r1, r2) >= 0) {
                int count = 0;
                for (int j = 0; j < pairs.length; j++) {
                    if (lieinCricle(pairs[j], stick1, r1) && lieinCricle(pairs[j], stick2, r2)) {
                        count++;
                    }
                }
                output = output.append(count + " ");
            } else {
                output = output.append("0 ");
            }
        }
        return output.toString().trim();

    }

    private static boolean lieinCricle(Pair pair, Pair stick, double radius) {

        double radius1 = radius(pair.x, pair.y, stick.x, stick.y);
        if (radius1 <= radius) {
            return true;
        }

        return false;
    }

    private static double radius(int x, int y, int a1, int b1) {
        return Math.sqrt((a1 - x) * (a1 - x) + (b1 - y) * (b1 - y));
    }

    private static int intersect(int x1, int y1, int x2, int y2, double r1, double r2) {
        double distSq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        int radSumSq = (int) ((r1 + r2) * (r1 + r2));
        if (distSq == radSumSq)
            return 1;
        else if (distSq > radSumSq)
            return -1;
        else
            return 0;
    }


}
