package leetCode;

import java.util.Random;

/**
 * Created by Gaurav on 01/05/18.
 */


public class _348 {


    class Solution {

        private final int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {

            int[] rand = nums.clone();
            for (int i = rand.length - 1; i >= 0; i--) {
                int index = random.nextInt(i + 1);
                int temp = rand[i];

                rand[i] = rand[index];
                rand[index] = temp;

            }
            return rand;

        }
    }


}
