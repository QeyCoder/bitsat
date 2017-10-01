import java.util.ArrayList;

/**
 * Created by Gaurav on 07/09/17.
 */
public class MaxArray {


    public static void main(String[] args) {
        MaxArray maxArray = new MaxArray();
        ArrayList<Integer> data = new ArrayList<>();
      /* data.add(1);
        data.add(2);
        data.add(5);
        data.add(-7);
        data.add(2);
        data.add(3);*/
        data.add(0);
        data.add(0);
        data.add(-1);
        data.add(0);
        maxArray.maxset(data);
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> data) {
        ArrayList<Integer> integers = new ArrayList<>(data.size());
        int sum = 0;
        int currentSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int tempStartIndex = 0;
        int tempEndIndex = 0;

        for (int i = 0; i < data.size(); i++) {
            Integer tempData = data.get(i);
            if (tempData < 0) {
                if(sum ==0){
                    startIndex = tempStartIndex;
                    endIndex = tempEndIndex;
                }
                tempStartIndex = tempEndIndex = i+1 ;
                currentSum = 0;
            } else {
                currentSum = currentSum + tempData;
                tempEndIndex++;
            }
            if (currentSum > sum) {
                sum = currentSum;
                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }

        for (int i = startIndex; i < endIndex; i++) {
            integers.add(data.get(i));
        }

        return integers;


    }

}
