package day11;

import java.util.Scanner;

/**
 * Created by Gaurav on 09/10/17.
 */
public class BalancedContest {


    public static void main(String[] args) {
        Scanner scanner
                = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= testCases; i++) {
            String[] splittedData = scanner.nextLine().split(" ");
            int noOfQuestion = Integer.parseInt(splittedData[0]);
            int noOPariticipant = Integer.parseInt(splittedData[1]);

            String[] noOfUserSolvedQuestion = scanner.nextLine().split(" ");

            int cakeWalkLimit = noOPariticipant / 2;
            int hardLimit = noOPariticipant / 10;
            int cake = 0;
            int hard = 0;
            for (String s : noOfUserSolvedQuestion) {
                int noOfUserSolved = Integer.parseInt(s);

                if (noOfUserSolved >= cakeWalkLimit) {
                    cake++;
                } else if (noOfUserSolved <= hardLimit) {
                    hard++;
                }
            }
            if (cake == 1 && hard == 2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        scanner.close();
    }


}
