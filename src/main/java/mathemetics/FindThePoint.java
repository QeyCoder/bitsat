package mathemetics;

import template.FastInputReader;

/**
 * @author Qey_coder on 3/6/18
 **/
//https://www.hackerrank.com/challenges/find-point/problem
public class FindThePoint {
    public static void main(String[] args) {


        FastInputReader fastInputReader
                = new FastInputReader();
        int N =
                fastInputReader.readInt();
        while (N-- > 0) {
            int px = fastInputReader.readInt();
            int py = fastInputReader.readInt();

            int qx = fastInputReader.readInt();
            int qy = fastInputReader.readInt();


            int[] r1 = getDistance(px, py, qx, qy);
        }
    }

    private static int[] getDistance(int px, int py, int qx, int qy) {

        return new int[]{2 * qx - px, 2 * qy - py};
    }
}
