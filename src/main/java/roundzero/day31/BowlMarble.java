package roundzero.day31;

import java.util.Scanner;

/**
 * Created by Gaurav on 27/11/17.
 */
public class BowlMarble {
    public static void main(String[] args) {
        Scanner scanner
                =  new
                Scanner(System.in);
        int no = Integer.parseInt(scanner.nextLine());

        String[] data = scanner.nextLine().split(" ");
        System.out.println(solution(data));
    }

    private static int solution(String[] data) {
        int carry = 1;
        for (int i = data.length-1; i >0; i--) {
            int d =  Integer.parseInt(data[i]);
            if(d<9){
            return i+1;
            }
        }
        return -1;
    }
}
