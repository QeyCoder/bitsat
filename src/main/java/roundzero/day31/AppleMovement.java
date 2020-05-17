package roundzero.day31;

import java.util.Scanner;

/**
 * Created by Gaurav on 27/11/17.
 */
public class AppleMovement {

    public static void main(String[] args) {
        Scanner scanner
                 =  new
                Scanner(System.in);
        int no = Integer.parseInt(scanner.nextLine());

        String[] data = scanner.nextLine().split(" ");
        System.out.println(solution(data));
    }

    private static long solution(String[] data) {


        long sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum+= Long.parseLong(data[i]);
        }
        long avg = sum / data.length;
            long count = 0;

        for (int i = 0; i < data.length; i++) {

            long val = avg - Long.parseLong(data[i]);

            if(val>0){
                count+=val;
            }


        }
        return count;
            
        

    }
}
