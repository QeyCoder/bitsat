package roundone;

import java.util.Arrays;

public class Solution1491 {
    static class Solution {
        public double average(int[] salary) {


            Arrays.sort(salary);


            return ((double)Arrays.stream(salary).sum()-salary[0]-salary[salary.length-1])/(salary.length-2);


        }
    }

    public static void main(String[] args) {
        new Solution().average(new int[]{4000,3000,1000,2000});
    }
}
