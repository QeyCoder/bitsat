package mathemetics;

import java.util.Scanner;

/**
 * @author QeyCoder on 3/6/18
 **/
public class TriangleFind {
    static int lowestTriangle(int base, int area) {
        return (int) Math.ceil(((double) 2 * area) / base);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int area = in.nextInt();
        int height = lowestTriangle(base, area);
        System.out.println(height);

    }
}
