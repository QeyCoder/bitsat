package day16;

/**
 * Created by Gaurav on 16/11/17.
 */
//https://www.hackerearth.com/challenge/hiring/nutanix-backend-developer-hiring-challenge/algorithm/help-1-0315faf6/
public class FriendsOnBeach {


    public static void main(String[] args) {


        InputReader inputReader = new InputReader(System.in);
        int noOfStation = inputReader.nextInt();
        int[] petrolStationDistance = new int[noOfStation];
        int[] petrolCapacity = new int[noOfStation];

        for (int i = 0; i < noOfStation; i++) {
            petrolStationDistance[i] = inputReader.nextInt();
            petrolCapacity[i] = inputReader.nextInt();
        }

        int initialDistance = inputReader.nextInt();
        int initialCapacity = inputReader.nextInt();

        solution(initialDistance, initialCapacity, petrolStationDistance, petrolCapacity);

    }

    private static void solution(int initialDistance, int initialCapacity, int[] petrolStationDistance, int[] petrolCapacity) {

    }
}
