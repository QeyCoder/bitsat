package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gaurav on 10/11/17.
 */
public class HelpOnTheBeach {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        int noOfPetrolPump = Integer.parseInt(bufferedReader.readLine());

        int[] petrolPumpDistance = new int[noOfPetrolPump];
        int[] petrolPumpCapacity = new int[noOfPetrolPump];

        for (int i = 0; i < noOfPetrolPump; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            petrolPumpDistance[i] = Integer.parseInt(input[0]);
            petrolPumpCapacity[i] = Integer.parseInt(input[1]);
        }
        String[] intialCar = bufferedReader.readLine().split(" ");
        int carDistance = Integer.parseInt(intialCar[0]);
        int carCapacity = Integer.parseInt(intialCar[1]);

        solution(carCapacity,carDistance,petrolPumpCapacity,petrolPumpDistance);


    }

    private static void solution(int carCapacity, int carDistance, int[] petrolPumpCapacity, int[] petrolPumpDistance) {

//PENDING
    }
}
