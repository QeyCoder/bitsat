package day63;

import java.util.*;

/**
 * Created by Gaurav on 07/04/18.
 */


public class Sum3 {


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> list = new HashSet<>();


        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;


                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[start]);
                        integers.add(nums[end]);
                        list.add(integers);
                        start++;
                        end--;
                    } else if (sum < 0) {
                        int current = start;
                        while (nums[start] == nums[current] && start < end) {
                            start++;
                        }
                    } else {
                        int current = end;
                        while (nums[end] == nums[current] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }

        ArrayList<List<Integer>> op = new ArrayList<>();
        op.addAll(list);
        return op;
    }

}
