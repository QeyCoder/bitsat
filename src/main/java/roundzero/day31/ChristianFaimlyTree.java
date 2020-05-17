package roundzero.day31;

import java.util.Scanner;

/**
 * Created by Gaurav on 27/11/17.
 */
public class ChristianFaimlyTree {

    public static void main(String[] args) {
        Scanner scanner
                = new
                Scanner(System.in);
        int no = Integer.parseInt(scanner.nextLine());

        int currentPlace = Integer.parseInt(scanner.nextLine());
        int placeToReached = Integer.parseInt(scanner.nextLine());
        System.out.println(solution(currentPlace, placeToReached));
    }

    private static boolean solution(int currentPlace, int placeToReached) {



        int target = getLeft(currentPlace);
        if(target>placeToReached){}

        return false;
    }


    static int getLeft(int i) {
        return 2 * i;
    }

    static int getRight(int i) {
        return 2 * i + 1;
    }

    static  int getLeftParent(int i) {
        return i / 2;
    }

    static     int getRightParent(int i) {
        return (i - 1) / 2;
    }

}
