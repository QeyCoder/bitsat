package roundzero.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 03/11/17.
 */
public class VillageAndTribe {


    public static void main(String[] args) throws IOException {


        BufferedReader
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int noOfCases = Integer.parseInt(bufferedReader.readLine());


        for (int i = 0; i < noOfCases; i++) {
            String input = bufferedReader.readLine();
            solveProblem(input);
        }
        bufferedReader.close();
    }

    private static void solveProblem(String input) {


        int coveredByA = 0;
        int coveredByB = 0;
        int tempA = 0;
        int tempB = 0;
        char lastFaced = ' ';
        for (int i = 0; i < input.length(); i++) {
            char ip = input.charAt(i);
            if (ip == 'A') {
                if (tempA > 0) {
                    coveredByA += tempA;
                    tempA = 0;
                }
                if(tempB>0){
                    tempB = 0;
                }
                lastFaced = 'A';
                coveredByA++;


            } else if (ip == 'B') {
                if (tempB > 0) {
                    coveredByB += tempB;
                    tempB = 0;
                }
                if(tempA>0){
                    tempA = 0;
                }
                lastFaced = 'B';
                coveredByB++;

            } else if (ip == '.') {


                if (lastFaced == 'B') {
                    tempB++;
                } else if (lastFaced == 'A') {
                    tempA++;
                }


            }


        }
        System.out.println(coveredByA + " " + coveredByB);

    }
}
