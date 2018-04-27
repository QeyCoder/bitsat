package day71;

/**
 * Created by Gaurav on 27/04/18.
 */


public class MaximumSubArrayProduct {


    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, -3, 4, -2, -4}));
    }

    public static int maxProduct(int[] nums) {


        int max = 0;
        int pro = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pro == 0) pro = nums[i];
            else pro *= nums[i];
            if (pro > max) {
                max = pro;
            }
        }
        pro = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (pro == 0) pro = nums[i];
            else pro *= nums[i];
            if (pro > max) {
                max = pro;
            }
        }
        return max;

    }


}
