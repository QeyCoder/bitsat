package day71;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 27/04/18.
 */


public class AllSubSet {


    public static void main(String[] args) {
        AllSubSet allSubSet
                = new AllSubSet();
        System.out.println(allSubSet.subsets(new int[]{}));
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        //blank set
        long setSize = 1l << (nums.length);


        for (int i = 0; i < setSize; i++) {
            ArrayList<Integer> set = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) > 0) {
                    set.add(nums[j]);
                }
            }
            lists.add(set);
        }

        return lists;
    }


}
