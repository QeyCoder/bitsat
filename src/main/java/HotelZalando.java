/**
 * Created by Gaurav on 30/09/17.
 */

public class HotelZalando {
    //A weight
    //B targetFloor
    //M no of floor
    //X no capacity
    //Y  weight capacity
    public static int solution(int[] A, int[] B, int noOfFloor, int countCapacity, int capacity) {
        int liftStopCount = 0;
        int noOfRequests = 0;
        //noOfRequests to track down the total no of peoples
        while (noOfRequests < A.length) {
            //Moving back to ground floor
            int currentWeight = 0;
            int currentCount = 0;
            int j = noOfRequests;

            while (noOfRequests < A.length && currentCount < countCapacity && currentWeight + A[noOfRequests++] < capacity) {
                if (noOfRequests >= A.length) break;
                //Adding persons to lift
                currentWeight += A[noOfRequests];
                currentCount++;
            }
            //While all persons get off the lift
            while (j < noOfRequests) {
                int currentFloor = B[j];
                while (j + 1 < A.length && currentFloor == B[j + 1]) {
                    j++;
                }
                liftStopCount++;
                j++;
            }
            liftStopCount++;
        }
        return liftStopCount;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{60}, new int[]{2}, 5, 2, 60));
        System.out.println(solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200));
        System.out.println(solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200));
    }
}
