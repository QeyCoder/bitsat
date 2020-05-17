package roundzero.day68;

import java.util.*;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {


        Collection<Integer> integers = new ArrayList<>();
        if(numbers == null){
            return integers;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();


        for (Integer number : numbers) {
            Integer val = hashMap.get(number);
            if (val == null) {
                val = 0;
            }
            hashMap.put(number, val + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue()==1){
                integers.add(entry.getKey());
            }
        }

        return integers;

    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}