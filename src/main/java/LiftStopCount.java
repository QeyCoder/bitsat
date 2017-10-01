
import java.util.*;

    /*
    This Java code is given for your convenience. Feel free to modify as required.
    */

public class LiftStopCount {
    public static long solveProblem() {
            /*

            Write solution code here

            */
        return 0;
    }

    //Sample code only. Feel free to change to accept the input described in the problem.

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int noOfFloor = Integer.parseInt(in.nextLine());
        String[] status = in.nextLine().split("-");
        int floorNO = Integer.parseInt(status[0]);
        Boolean currentDirection = getDirection(status[1]);


        String[] requestInqueue = in.nextLine().split(",");

        Map<Integer, Boolean> requestMap = new LinkedHashMap<>();
        for (String request : requestInqueue) {
            String[] splittedRequest = request.split("-");
            Boolean direction = getDirection(splittedRequest[1]);
            requestMap.put(Integer.parseInt(splittedRequest[0]), direction);
        }
        ArrayList<Integer> reversedList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        Iterator<Map.Entry<Integer, Boolean>> mapIterator = requestMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<Integer, Boolean> entry = mapIterator.next();
            if (entry.getValue() == currentDirection) {
                integerList.add(entry.getKey());
                mapIterator.remove();
                if (!requestMap.values().contains(currentDirection)) {
                    currentDirection = !currentDirection;
                    reversedList.addAll(requestMap.keySet());
                    Collections.reverse(reversedList);
                    break;
                }
            }
        }
        reversedList.forEach(integer -> {
            integerList.add(integer);
        });

        final String[] finalString = {new String()};
        integerList.forEach(integer -> {
            finalString[0] = finalString[0].concat(String.valueOf(integer) + ",");

        });
        System.out.println(finalString[0].substring(0, finalString[0].length() - 1));


    }

    private static Boolean getDirection(String s) {
        return s.equalsIgnoreCase("up") ? Boolean.TRUE : Boolean.FALSE;
    }
}