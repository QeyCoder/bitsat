package day35;

import java.util.*;

/**
 * Created by Gaurav on 18/12/17.
 */
public class SumCombination {
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8};
        int sum = 8;
        solution(arr, sum);
    }

    private static void solution(int[] arr, int sum) {
        //sort an array
        Arrays.sort(arr);
        HashSet<Integer> integers
                = new LinkedHashSet<>();
        for (int i : arr) {
            integers.add(i);
        }
        Integer[] y = integers.toArray(new Integer[0]);

        List<List<Integer>> sumArray = new ArrayList<>();
        combinationSum(y, sumArray, new ArrayList<>(), sum, 0);
        for (List<Integer> integerList : sumArray) {
            System.out.println(integerList);
        }
    }

    private static void combinationSum(Integer[] y, List<List<Integer>> sumArray, ArrayList<Integer> s, int sum, int i) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {//creating new list to avoid object reference while removing element
            sumArray.add(new ArrayList<>(s));
            return;
        }
        while (i < y.length && sum - y[i] >= 0) {
            s.add(y[i]);
            combinationSum(y, sumArray, s, sum - y[i], i);
            i++;
            s.remove(s.size() - 1);
        }
    }


}
