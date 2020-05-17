package roundzero.day123;

import java.util.*;

/**
 * Created by Gaurav on 29/09/17.
 */
public class NobleNumber {
    public int solve(ArrayList<Integer> A) {
        A.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();


        Iterator<Integer> iter = A.iterator();


        while (iter.hasNext()) {
            Integer no = iter.next();
            iter.remove();
            integerIntegerMap.put(no, A.size());
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : integerIntegerMap.entrySet()) {

            if(integerIntegerEntry.getKey()-integerIntegerEntry.getValue()==0){
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NobleNumber nobleNumber = new NobleNumber();

        ArrayList<Integer> data = new ArrayList<>();
        Integer[] d = {7, 2, 3, 6};
        data.addAll(Arrays.asList(d));
        System.out.println(nobleNumber.solve(data));
    }


}
