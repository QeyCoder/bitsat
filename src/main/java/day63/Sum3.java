package day63;

import java.util.*;

/**
 * Created by Gaurav on 07/04/18.
 */


public class Sum3 {


    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int no = nums[i];
            integers.add(no);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int sum = nums[i] + nums[j];
                    boolean yes = integers.contains(-sum);
                    if (yes) {
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(-sum);

                        Collections.sort(ls);
                        list.add(ls);
                    }
                }
            }
        }
        ArrayList<List<Integer>> op = new ArrayList<>();
        op.addAll(list);
        return op;
    }

}
